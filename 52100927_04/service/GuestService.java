package service;

import model.Guest;
import model.table.GuestTable;

public interface GuestService {


    void save(Guest guest);

    GuestTable getAllGuest();

    
}
