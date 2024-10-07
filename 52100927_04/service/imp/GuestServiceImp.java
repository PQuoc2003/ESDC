package service.imp;

import model.Guest;
import model.table.GuestTable;
import repository.GuestRepository;
import service.GuestService;

public class GuestServiceImp implements GuestService {

    private final GuestRepository guestRepository;

    public GuestServiceImp(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    @Override
    public void save(Guest guest) {

        this.guestRepository.save(guest);

    }

    @Override
    public GuestTable getAllGuest() {

        return this.guestRepository.getAllGuest();

    }

}
