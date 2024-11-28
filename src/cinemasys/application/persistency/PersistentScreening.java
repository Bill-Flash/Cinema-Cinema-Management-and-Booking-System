package cinemasys.application.persistency;

import cinemasys.application.domain.Movie;
import cinemasys.application.domain.MovieScreening;
import cinemasys.application.domain.Screen;

import java.time.LocalDate;
import java.time.LocalTime;

public class PersistentScreening extends MovieScreening {

    private int oid;
    public PersistentScreening(LocalDate date, LocalTime time, Movie movie, Screen screen, int oid) {
        super(date, time, movie, screen);
        this.oid = oid;
    }

    public int getId() {
        return oid;
    }

}
