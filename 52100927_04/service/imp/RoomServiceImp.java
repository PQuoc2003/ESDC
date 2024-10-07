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

    @Override
    public boolean updateQuantity(String room_type, boolean isIncrease) {

        Room room = this.roomRepository.getAvailableRoomByRoomType(room_type);

        int remain = room.getRemainRoom();

        if (remain == 0 && !isIncrease)
            return false;

        if (remain == room.getTotalRoom() && isIncrease)
            return false;

        if (isIncrease) {
            remain += 1;
        } else {
            remain -= 1;
        }

        room.setRemainRoom(remain);

        return this.roomRepository.update(room);

    }

    public boolean checkAvailableByRoomType(String room_type) {

        Room room = this.roomRepository.getAvailableRoomByRoomType(room_type);

        int remain = room.getRemainRoom();

        if (remain == 0)
            return false;

        return true;

    }

}
