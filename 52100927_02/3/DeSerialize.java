import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeSerialize {
    public static void main(String[] args) {
        Library library = null;


        try {
            FileInputStream f = new FileInputStream("library.ser");
            ObjectInputStream in = new ObjectInputStream(f);


            library = (Library) in.readObject();

            System.out.println(library);


            in.close();
            f.close();




        } catch (Exception e) {
            e.printStackTrace();
            // System.out.println("error");
        }
    }
}
