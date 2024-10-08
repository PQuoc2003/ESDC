import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import model.table.GuestTable;
import model.Room;

public interface Hotel extends Remote{


    ArrayList<String> helpList() throws RemoteException;

    String login(String username, String password) throws RemoteException;

    ArrayList<Room> getAvailableRoom() throws RemoteException;

    boolean book(String room_type, String guest_name, String ssn) throws RemoteException;

    GuestTable guestList() throws RemoteException;

    boolean logout() throws RemoteException;




    
}
