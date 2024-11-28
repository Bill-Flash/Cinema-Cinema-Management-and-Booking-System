package cinemasys.application.persistency;

import cinemasys.storage.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class MovieMapper {

    private static MovieMapper uniqueInstance;
    private Map<Integer, PersistentMovie> cache;

    // Constructor:
    private MovieMapper() {
        cache = new HashMap<Integer, PersistentMovie>();
    }

    public static MovieMapper getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new MovieMapper();
        }
        return uniqueInstance;
    }

    //get from the Id
    private PersistentMovie getFromCache(int oid) {
        return cache.get(oid);
    }

    //get from the number
    private PersistentMovie getFromCacheByDetails(String name, int duration) {
        for (PersistentMovie pm : cache.values()) {
            if (name.equals(pm.getName()) && duration == pm.getDuration()) {
                return pm;
            }
        }
        return null;
    }

    private void addToCache(PersistentMovie c) {
        cache.put(c.getId(), c);
    }

    public PersistentMovie getMovie(String n, int capacity) {
        PersistentMovie c = getFromCacheByDetails(n, capacity);
        if (c == null) {
            c = getMovie("SELECT * FROM Movie WHERE name = '" + n + "' AND capacity = '" + capacity + "'");
            if (c == null) {
                c = addMovie(n, capacity);
            }
            addToCache(c);
        }
        return c;
    }

    PersistentMovie getMovieForOid(int oid) {
        PersistentMovie c = getFromCache(oid);
        if (c == null) {
            c = getMovie("SELECT * FROM Movie WHERE oid ='" + oid + "'");
            if (c != null) {
                addToCache(c);
            }
        }
        return c;
    }

    private PersistentMovie getMovie(String sql) {
        PersistentMovie c = null;
        try {
            Database.getInstance();
            Statement stmt = Database.getConnection().createStatement();
            ResultSet rset = stmt.executeQuery(sql);
            while (rset.next()) {
                int oid = rset.getRow();
                String name = rset.getString("name");
                int capacity = rset.getInt("capacity");
                c = new PersistentMovie(oid, name, capacity);
            }
            rset.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    PersistentMovie addMovie(String name, int capacity) {
        PersistentMovie c = getFromCacheByDetails(name, capacity);
        if (c == null) {
            try {
                Database.getInstance();
                Statement stmt = Database.getConnection().createStatement();
                stmt.executeUpdate("INSERT INTO Movie (name, capacity)" + "VALUES ('" + name + "', '" + capacity + "')");
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            c = getMovie(name, capacity);
        }
        return c;
    }






}