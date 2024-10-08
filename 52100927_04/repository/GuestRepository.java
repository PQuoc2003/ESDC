package repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import model.Guest;
import model.table.GuestTable;

public class GuestRepository {

    public boolean save(Guest guest) {

        File file = new File("resources/guest.ser");

        FileInputStream f = null;

        GuestTable guestTable = null;

        if (file.exists()) {
            try {
                f = new FileInputStream("resources/guest.ser");
                ObjectInputStream in = new ObjectInputStream(f);

                guestTable = (GuestTable) in.readObject();

                in.close();
                f.close();

            } catch (Exception e) {
                return false;
            }
        }

        if (guestTable == null) {
            guestTable = new GuestTable();
        }


        guestTable.addGuest(guest);



        try {
            FileOutputStream f1 = new FileOutputStream("resources/guest.ser", true);
            ObjectOutputStream out = new ObjectOutputStream(f1);

            out.writeObject(guestTable);

            out.close();
            f1.close();
            
        } catch (Exception e) {
            return false;
        }


        return true;

    }


    public GuestTable getAllGuest(){

        File file = new File("resources/guest.ser");

        FileInputStream f = null;

        if (!file.exists())
            return null;
        
        GuestTable guestTable = null;

        try {
            f = new FileInputStream("resources/guest.ser");
            ObjectInputStream in = new ObjectInputStream(f);

            guestTable = (GuestTable) in.readObject();

            in.close();
            f.close();

        } catch (Exception e) {
            return null;
        }

        return guestTable;

    }


}
