package cinemasys.application.persistency;

import cinemasys.application.domain.Movie;

public class PersistentMovie extends Movie {

    private int oid;

    public PersistentMovie(int oid, String name, int duration) {
        super(name, duration);
        this.oid = oid;
    }

    int getId() {
        return oid;
    }
}
