package repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

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

    
}
