package cinemasys.application.persistency;

import cinemasys.application.domain.Screen;

public class PersistentScreen extends Screen {

    private int oid;

    public PersistentScreen(int id, int capacity, int number) {
        super(capacity, number);
        oid = id;
    }

    int getId() {
        return oid;
    }
}
