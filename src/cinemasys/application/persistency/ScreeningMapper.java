package cinemasys.application.persistency;

import cinemasys.application.domain.Movie;
import cinemasys.application.domain.MovieScreening;
import cinemasys.application.domain.Screen;
import cinemasys.storage.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ScreeningMapper {
    private static ScreeningMapper uniqueInstance;

    public static ScreeningMapper getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new ScreeningMapper();
        }
        return uniqueInstance;
    }

    public List<MovieScreening> getMovieScreenings(LocalDate currentDate) {
        List<MovieScreening> movieScreenings = new ArrayList<MovieScreening>();
        try {
            Database.getInstance();
            Statement stmt = Database.getConnection().createStatement();
            ResultSet rset = stmt.executeQuery("SELECT * FROM MovieScreening WHERE date='" + currentDate + "'");
            while (rset.next()) {
                int oid = rset.getInt("oid");
                LocalDate date = LocalDate.parse(rset.getString("date"));
                LocalTime time = LocalTime.parse(rset.getString("time"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movieScreenings;
    }

    public List<MovieScreening> getScreenings(LocalDate currentDate) {
        List<MovieScreening> movieScreenings = new ArrayList<MovieScreening>();
        try {
            Database.getInstance();
            Statement stmt = Database.getConnection().createStatement();
            ResultSet rset = stmt.executeQuery("SELECT * FROM MovieScreening WHERE date='" + currentDate + "'");
            
            while (rset.next()) {
                int oid = rset.getInt("oid");
                LocalDate bdate = LocalDate.parse(rset.getString("date"));
                LocalTime btime = LocalTime.parse(rset.getString("time"));
                int screen = rset.getInt("screen_id");
                int movie = rset.getInt("movie_id");
                
                PersistentScreen ps = ScreenMapper.getInstance().getScreenForOid(screen);
                PersistentMovie pm = MovieMapper.getInstance().getMovieForOid(movie);
                
                PersistentScreening r = new PersistentScreening(bdate, btime, pm, ps,oid);
                movieScreenings.add(r);
                
            }
            rset.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movieScreenings;
    }

    public PersistentScreening addScreening(int covers, LocalDate date, LocalTime time, Screen screen, Movie movie) {
        int oid = Database.getInstance().getId();
        performUpdate("INSERT INTO MovieScreening " + "VALUES ('" + oid + "', '" + "', '" + date.toString() + "', '" + time.toString() + "', '"
                + ((PersistentScreen) screen).getId() + "', '" + ((PersistentMovie) movie).getId() + ")");

        return new PersistentScreening(date, time, movie,screen ,oid);
    }


    //TODO
    public void updateScreening(MovieScreening ms) {
        PersistentScreening pms = (PersistentScreening) ms;

    }

    public void deleteScreening(MovieScreening b) {
        performUpdate("DELETE FROM MovieScreening"+ " WHERE rowid = '" + ((PersistentScreening) b).getId() + "'");
    }

    private void performUpdate(String sql) {
        try {
            Database.getInstance();
            Statement stmt = Database.getConnection().createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
