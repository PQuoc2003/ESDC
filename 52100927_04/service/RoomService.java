package service;

import java.util.ArrayList;
import model.Room;

public interface RoomService {

    ArrayList<Room> getAvailableRooms();

    boolean updateQuantity(String room_type, boolean isIncrease);

    boolean checkAvailableByRoomType(String room_type);
    
    
}
