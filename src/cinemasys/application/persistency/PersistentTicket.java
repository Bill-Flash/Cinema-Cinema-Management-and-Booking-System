package cinemasys.application.persistency;

import cinemasys.application.domain.MovieScreening;
import cinemasys.application.domain.Ticket;

public class PersistentTicket extends Ticket {

    private int oid;
    public PersistentTicket(MovieScreening movieScreening, int oid) {
        super(movieScreening);
        this.oid = oid;
    }

    public int getId() {
        return oid;
    }
}
