package cinemasys.application.domain;

public class Movie {
    String name;
    int duration;

    public Movie(String name, int duration){
        this.name = name;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }
}
