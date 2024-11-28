package cinemasys.application.domain;

import cinemasys.application.domain.MovieScreening;

public class Ticket {
    private MovieScreening movieScreening;
    public Ticket(MovieScreening movieScreening){
        this.movieScreening = movieScreening;
    }

    public MovieScreening getMovieScreening() {
        return movieScreening;
    }

    public void setMovieScreening(MovieScreening movieScreening) {
        this.movieScreening = movieScreening;
    }
}
