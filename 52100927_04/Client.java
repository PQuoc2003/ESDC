import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import java.util.ArrayList;

import model.Guest;
import model.Room;
import model.table.GuestTable;

public class Client {
    public Client() {
    }

    public static void main(String[] args) {
        try {

            int length = args.length;

            if (length < 2) {
                System.out.println("Wrong input format");
                return;
            }

            int index = 0;

            String host = args[index++];

            int port = Integer.parseInt(args[index++]);

            Registry registry = LocateRegistry.getRegistry(host, port);

            Hotel hotel = (Hotel) registry.lookup("Hotel");

            if (length == 2) {
                ArrayList<String> helpList = hotel.helpList();

                for (String help : helpList) {
                    System.out.println(help);
                }

                return;

            }

            switch (args[index++]) {
                case "help":

                    ArrayList<String> helpList = hotel.helpList();

                    for (String help : helpList) {
                        System.out.println(help);
                    }

                    break;

                case "-logIn":

                    if (length != 5) {
                        System.out.println("Wrong format");
                        return;
                    }

                    String username = args[index++];
                    String password = args[index++];

                    String status = hotel.login(username, password);

                    System.out.println(status);

                    break;

                case "-list":

                    ArrayList<Room> rooms = hotel.getAvailableRoom();

                    if (rooms == null) {
                        System.out.println("You need to log in");
                        return;
                    }

                    for (Room room : rooms) {
                        System.out.println(room);
                    }

                    break;

                case "-book":

                    if (length != 5 && length != 6) {
                        System.out.println("Wrong format");
                        return;
                    }

                    String room_type = args[index++];
                    String guest_name = args[index++];
                    String ssn = "";

                    if (length == 6) {
                        ssn = args[index++];
                    }

                    boolean bookStatus = hotel.book(room_type, guest_name, ssn);

                    if (bookStatus) {
                        System.out.println("Booked successfully");
                        return;
                    }

                    System.out.println("Fail when booking");

                    break;

                case "-guest":

                    GuestTable guestTable = hotel.guestList();

                    if (guestTable == null) {
                        System.out.println("You don't have permission to use this command");
                        return;
                    }

                    ArrayList<Guest> guests = guestTable.getGuests();

                    System.out.println("List of guest in hotel:");

                    for (Guest guest : guests) {
                        System.out.println(guest);
                    }

                    break;

                case "-logOut":
                    boolean isLogout = hotel.logout();

                    if(!isLogout){
                        System.out.println("You need to login first");
                    } else {
                        System.out.println("Logout successfully");
                    }


                    break;

                default:

                    break;
            }

        } catch (Exception e) {

            System.err.println(e.toString());

        }
    }

}
