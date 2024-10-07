package model.table;

import java.io.Serializable;
import java.util.ArrayList;
import model.Guest;


public class GuestTable implements Serializable{

    private ArrayList<Guest> guests;

    

    public GuestTable() {
    }

    public GuestTable(ArrayList<Guest> guests) {
        this.guests = guests;
    }

    public ArrayList<Guest> getGuests() {
        return guests;
    }

    public void setGuests(ArrayList<Guest> guests) {
        this.guests = guests;
    }

    public void addGuest(Guest guest){
        this.guests.add(guest);
    }

    

    


    

    
}
