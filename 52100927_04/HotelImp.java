import java.util.ArrayList;
import java.util.Random;

import model.table.GuestTable;
import model.Guest;
import model.Role;
import model.Room;
import repository.EmployeeRepository;
import repository.GuestRepository;
import repository.RoomRepository;
import service.imp.EmployeeServiceImp;
import service.imp.GuestServiceImp;
import service.imp.RoomServiceImp;
import cookies.Information;

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

        if (!status)
            return "Login fail";

        return "Login successfully";

    }

    @Override
    public ArrayList<Room> getAvailableRoom() {

        if (Information.currentEmployee == null) {
            return null;
        }

        RoomRepository roomRepository = new RoomRepository();
        RoomServiceImp roomServiceImp = new RoomServiceImp(roomRepository);

        return roomServiceImp.getAvailableRooms();

    }

    @Override
    public boolean book(String room_type, String guest_name, String ssn) {

        if(Information.currentEmployee == null) return false;

        RoomRepository roomRepository = new RoomRepository();
        RoomServiceImp roomServiceImp = new RoomServiceImp(roomRepository);

        GuestRepository guestRepository = new GuestRepository();
        GuestServiceImp guestServiceImp = new GuestServiceImp(guestRepository);

        boolean isAvailable = roomServiceImp.checkAvailableByRoomType(room_type);

        if (!isAvailable)
            return false;

        if(ssn.equals("")){
            Random random = new Random();

            for(int i = 0; i < 6; i++){
                ssn += String.valueOf(random.nextInt(10));
            }

        }

        Guest guest = new Guest(guest_name, ssn, room_type);

        roomServiceImp.updateQuantity(room_type, false);

        guestServiceImp.save(guest);

        return true;

    }

    @Override
    public GuestTable guestList() {

        GuestRepository guestRepository = new GuestRepository();
        GuestServiceImp guestServiceImp = new GuestServiceImp(guestRepository);

        if(Information.currentEmployee == null) return null;

        if (Information.currentEmployee.getRole() != Role.ROlE_MANAGER)
            return null;

        GuestTable guestTable = guestServiceImp.getAllGuest();

        if (guestTable == null)
            guestTable = new GuestTable();

        return guestTable;

    }

    @Override
    public void logout() {

        Information.currentEmployee = null;

    }

}
