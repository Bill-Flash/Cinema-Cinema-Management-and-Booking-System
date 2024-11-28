package cinemasys.application.domain;

public class Screen {

    private int number;
    int capacity;
    public Screen(int capacity, int number){
        this.capacity = capacity;
        this.number = number;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getNumber() {
        return number;
    }
}
