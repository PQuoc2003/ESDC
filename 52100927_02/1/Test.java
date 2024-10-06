import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Test {
    public static void main(String[] args) {
        Person p = new Person();


        try {
            FileOutputStream f = new FileOutputStream("person.ser");
            ObjectOutputStream o = new ObjectOutputStream(f);

            o.writeObject(p);
            o.close();
            f.close();
        } catch (Exception e) {
            System.out.println("error");
        }


    }
}
