package model.table;

import java.io.Serializable;
import java.util.ArrayList;

import model.Room;

public class RoomTable implements Serializable{

    private ArrayList<Room> rooms;

    public RoomTable() {
        rooms = new ArrayList<>();
    }

    public RoomTable(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public void addRoom(Room room){
        this.rooms.add(room);
    }

    
}
