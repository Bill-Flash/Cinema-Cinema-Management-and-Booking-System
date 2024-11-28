package cinemasys.storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseCreator {
  public static void main(String[] args) {


    String url = "jdbc:sqlite:cinemaDB.db";
    try (Connection conn = DriverManager.getConnection(url)) {
      if (conn != null) {
        Statement stmt = conn.createStatement();
        String sql = "CREATE TABLE  IF NOT EXISTS Oid (\r\n" +
            "       last_id      INT NOT NULL\r\n" + 
            ") ;";
        stmt.execute(sql);


        stmt = conn.createStatement();
        sql = "CREATE TABLE  IF NOT EXISTS Screen (\r\n" +
            "       number      INT NOT NULL,\r\n" +
            "       capacity      INT NOT NULL\r\n" +
            ");";
        stmt.execute(sql);


        stmt = conn.createStatement();
        sql = "CREATE TABLE  IF NOT EXISTS Movie (\r\n" +
            "       name     VARCHAR(32) NOT NULL,\r\n" +
            "       duration      INT NOT NULL\r\n" +
            ") ;";
        stmt.execute(sql);

        
        stmt = conn.createStatement();
        sql = "CREATE TABLE IF NOT EXISTS MovieScreening (\r\n" +
            "       oid      int NOT NULL PRIMARY KEY,\r\n" + 
            "       sold_id     int,\r\n" + 
            "       date     VARCHAR(32),\r\n" + 
            "       time     VARCHAR(32),\r\n" + 
            "       movie_id     int,\r\n" +
            "       screen_id     int\r\n" +
            ") ;";
        stmt.execute(sql);
        
        stmt = conn.createStatement();
        sql = "INSERT INTO Oid VALUES (0) ;";
        stmt.execute(sql);
        stmt = conn.createStatement();
        sql = "INSERT INTO Screen (number, capacity) VALUES (1, 30) ;";
        stmt.execute(sql);
        stmt = conn.createStatement();
        sql = "INSERT INTO Screen (number, capacity) VALUES (2, 40) ;";
        stmt.execute(sql);
        stmt = conn.createStatement();
        sql = "INSERT INTO Screen (number, capacity) VALUES (3, 35) ;";
        stmt.execute(sql);
        stmt = conn.createStatement();
        sql = "INSERT INTO Screen (number, capacity) VALUES (4, 50) ;";
        stmt.execute(sql);
        stmt = conn.createStatement();
        sql = "INSERT INTO Screen (number, capacity) VALUES (5, 20) ;";
        stmt.execute(sql);
        stmt = conn.createStatement();
        sql = "INSERT INTO Screen (number, capacity) VALUES (6, 30) ;";
        stmt.execute(sql);
        stmt = conn.createStatement();
        sql = "INSERT INTO Screen (number, capacity) VALUES (7, 25) ;";
        stmt.execute(sql);
        stmt = conn.createStatement();
        sql = "INSERT INTO Screen (number, capacity) VALUES (8, 15) ;";
        stmt.execute(sql);
        stmt = conn.createStatement();
        sql = "INSERT INTO Screen (number, capacity) VALUES (9, 20) ;";
        stmt.execute(sql);
        stmt = conn.createStatement();
        sql = "INSERT INTO Screen (number, capacity) VALUES (10, 30) ;";
        stmt.execute(sql);
        
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
