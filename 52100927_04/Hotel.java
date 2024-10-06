import java.rmi.Remote;
import java.util.ArrayList;

import model.table.GuestTable;
import model.Room;

public interface Hotel extends Remote{


    public ArrayList<String> helpList();

    public String login(String username, String password);

    public ArrayList<Room> getAvailableRoom();

    public boolean book(String room_type, String guest_name, String ssn);

    public GuestTable guestList();

    public void logout();




    
}
