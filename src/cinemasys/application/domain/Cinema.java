package cinemasys.application.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cinema {
    private LocalDate currentDate;
    // Associations:
    private Cinema            Cinema = null;
    private List<MovieScreening> currentMovieScreenings;
    private MovieScreening               selectedMovieScreening;

    private List<CinemaObserver> observers  = new ArrayList<CinemaObserver>();
    private static CinemaSystem uniqueInstance;
    
}
