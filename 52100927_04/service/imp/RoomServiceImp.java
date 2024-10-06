package service.imp;

import java.util.ArrayList;

import model.Room;
import model.table.RoomTable;
import repository.RoomRepository;
import service.RoomService;

public class RoomServiceImp implements RoomService {

    private final RoomRepository roomRepository;

    public RoomServiceImp(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public ArrayList<Room> getAvailableRooms() {

        RoomTable roomTable = roomRepository.getAvailableRoom();

        if (roomTable == null) {
            return null;
        }

        return roomTable.getRooms();

    }

}
