package cinemasys.application.persistency;

import cinemasys.application.domain.Screen;
import cinemasys.storage.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScreenMapper {
    
    
    private static ScreenMapper uniqueInstance;
    private Map<Integer, PersistentScreen> cache;
    
    // Constructor:
    private ScreenMapper() {
        cache = new HashMap<Integer, PersistentScreen>();
        getScreens();
    }
    
    public static ScreenMapper getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new ScreenMapper();
        }
        return uniqueInstance;
    }

    //get from the Id
    private PersistentScreen getFromCache(int oid) {
        return cache.get(oid);
    }

    //get from the number
    private PersistentScreen getFromCacheByNumber(int sno) {
        for (PersistentScreen ps : cache.values()) {
            if (ps.getNumber() == sno) {
                return ps;
            }
        }
        return null;
    }

    public PersistentScreen getScreen(int sno) {
        PersistentScreen ps = getFromCacheByNumber(sno);
        return ps;
    }

    //why is default?
    PersistentScreen getScreenForOid(int oid) {
        PersistentScreen ps = getFromCache(oid);
        return ps;
    }


    private void addToCache(PersistentScreen ps) {
        cache.put(ps.getId(), ps);
    }

    public List<Screen> getScreens() {
        
        if (cache.size() == 0) {
            
            List<Screen> screens = new ArrayList<Screen>();
            try {
                Database.getInstance();
                Statement stmt = Database.getConnection().createStatement();
                ResultSet rset = stmt.executeQuery("SELECT ROWID, number, capacity FROM `Screen` ORDER BY number");
                while (rset.next()) {
                    PersistentScreen ps = new PersistentScreen(rset.getInt("ROWID"), rset.getInt("number"), rset.getInt("capacity"));
                    screens.add(ps);
                    addToCache(ps);
                }
                rset.close();
                stmt.close();
                
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return screens;
        } else {
            
            return new ArrayList<Screen>(cache.values());
        }
    }
    
    

}
