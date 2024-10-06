package repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.Room;
import model.table.RoomTable;

public class RoomRepository {


    public RoomTable getAvailableRoom(){
        File file = new File("../resources/room.ser");

        FileInputStream f = null;

        if (!file.exists())
            return null;
        
        RoomTable roomTable = null;

        try {
            f = new FileInputStream("../resources/room.ser");
            ObjectInputStream in = new ObjectInputStream(f);

            roomTable = (RoomTable) in.readObject();

            in.close();
            f.close();

        } catch (Exception e) {
            return null;
        }

        return roomTable;
    }

    public boolean update(Room room) {

        File file = new File("../resources/room.ser");

        FileInputStream f = null;

        RoomTable roomTable = null;

        if (file.exists()) {
            try {
                f = new FileInputStream("../resources/room.ser");
                ObjectInputStream in = new ObjectInputStream(f);

                roomTable = (RoomTable) in.readObject();

                in.close();
                f.close();

            } catch (Exception e) {
                return false;
            }
        }

        if (roomTable == null) {
            return false;
        }

        ArrayList<Room> rooms = roomTable.getRooms();

        for (Room room2 : rooms) {
            if (room2.getType().equals(room.getType())) {
                room2.setRemainRoom(room.getRemainRoom());
            }
        }

        roomTable.setRooms(rooms);

        try {

            FileOutputStream f1 = new FileOutputStream("../resources/room.ser", false);
            ObjectOutputStream out = new ObjectOutputStream(f1);

            out.writeObject(roomTable);

            out.close();
            f1.close();
            
        } catch (Exception e) {
            return false;
        }


        return true;

    }

    

    
}
