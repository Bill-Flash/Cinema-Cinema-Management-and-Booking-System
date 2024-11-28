package cinemasys.application.domain;

import java.time.LocalDate;
import java.time.LocalTime;

public class MovieScreening {

    private LocalDate date;
    private LocalTime time;
    private Movie movie;
    private Screen screen;
    private Ticket[] tickets_sold;
    private int soldId;

    public MovieScreening(LocalDate date, LocalTime time, Movie movie, Screen screen){
        this.date = date;
        this.time = time;
        this.movie = movie;
        this.screen = screen;
        this.tickets_sold = new Ticket[screen.getCapacity()];
    }

    public int getScreenNumber(){

        return screen.getNumber();

    }

    public Screen getScreen(){
        return screen;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public LocalTime getTime() {
        return time;
    }

    public LocalTime getEndTime(){
        return time.plusMinutes(movie.getDuration());
    }
}
