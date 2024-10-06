import java.util.ArrayList;

import model.table.GuestTable;
import model.Room;
import repository.EmployeeRepository;
import repository.RoomRepository;
import service.imp.EmployeeServiceImp;
import service.imp.RoomServiceImp;

public class HotelImp implements Hotel {

    @Override
    public ArrayList<String> helpList() {

        ArrayList<String> helpList = new ArrayList<>();

        helpList.add("java HotelClient host port [help]");
        helpList.add("java HotelClient host port -logIn <username> <password>");
        helpList.add("java HotelClient host port -list");
        helpList.add("java HotelClient host port -book <room_type> <guest_name> [guest_ssn]");
        helpList.add("java HotelClient host port -guest");
        helpList.add("java HotelClient host port -logOut");

        return helpList;

    }

    @Override
    public String login(String username, String password) {

        EmployeeRepository employeeRepository = new EmployeeRepository();

        EmployeeServiceImp employeeServiceImp = new EmployeeServiceImp(employeeRepository);

        boolean status = employeeServiceImp.login(username, password);

        if(!status) return "Login fail";

        return "Login successfully";

    }

    @Override
    public ArrayList<Room> getAvailableRoom() {

        RoomRepository roomRepository = new RoomRepository();
        RoomServiceImp roomServiceImp = new RoomServiceImp(roomRepository);

        return roomServiceImp.getAvailableRooms();

    }

    @Override
    public boolean book(String room_type, String guest_name, String ssn) {

        return true;


    }

    @Override
    public GuestTable guestList() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'guestList'");
    }

    @Override
    public void logout() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'logout'");
    }
    
}
