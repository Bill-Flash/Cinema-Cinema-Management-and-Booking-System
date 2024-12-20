package cinemasys.storage;

import java.sql.*;

public class Database {

    private static Connection con;

    // Singleton:

    private static Database uniqueInstance;

    public static Database getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Database();
        }
        return uniqueInstance;
    }

    private Database() {
        try {
            con = DriverManager.getConnection("jdbc:sqlite:./cinemaDB.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return con;
    }

    // Get a fresh object ID

    public int getId() {
        int id = 0;
        try {
            Statement stmt = con.createStatement();

            ResultSet rset = stmt.executeQuery("SELECT * FROM Oid");
            while (rset.next()) {
                id = rset.getInt(1);
            }
            rset.close();

            id++;

            stmt.executeUpdate("UPDATE Oid SET last_id = '" + id + "'");
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }

}
