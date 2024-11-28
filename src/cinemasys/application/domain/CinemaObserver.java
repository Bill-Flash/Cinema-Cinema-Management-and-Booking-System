package cinemasys.application.domain;

public interface CinemaObserver {

    public void update();
    public boolean message(String s, boolean confirm);

}
