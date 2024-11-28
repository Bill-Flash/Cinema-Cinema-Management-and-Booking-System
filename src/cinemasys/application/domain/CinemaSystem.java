package cinemasys.application.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class CinemaSystem {

    private LocalDate currentDate;
    // Associations:
    private Cinema cinema = null;
    private List<MovieScreening> currentScreenings;
    private MovieScreening  selectedScreening;

    private List<CinemaObserver> observers  = new ArrayList<CinemaObserver>();
    private static CinemaSystem  uniqueInstance;

    private CinemaSystem() {
        cinema = new Cinema();
    }

    public static CinemaSystem getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new CinemaSystem();
        }
        return uniqueInstance;
    }

    public void addObserver(CinemaObserver o) {
        observers.add(o);
    }

    public void notifyObservers() {
        for (CinemaObserver bo : observers) {
            bo.update();
        }
    }

    public boolean observerMessage(String message, boolean confirm) {
        CinemaObserver bo = (CinemaObserver) observers.get(0);
        return bo.message(message, confirm);
    }

    public void selectBooking(int sno, LocalTime time) {
        selectedScreening = null;
        for (MovieScreening ms : currentScreenings) {
            if (ms.getScreenNumber() == sno) {
                if (ms.getTime().isBefore(time) && ms.getEndTime().isAfter(time)) {
                    selectedScreening = ms;
                }
            }
        }
        notifyObservers();
    }

//    public void cancelSelected() {
//        if (selectedScreening != null) {
//            if (observerMessage("Are you sure?", true)) {
//                currentScreenings.remove(selectedScreening);
//                restaurant.removeBooking(selectedBooking);
//                selectedBooking = null;
//                notifyObservers();
//            }
//        }
//    }





}
