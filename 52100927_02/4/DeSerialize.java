import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeSerialize {
    public static void main(String[] args) {
        Student student = null;


        try {
            FileInputStream f = new FileInputStream("student.ser");
            ObjectInputStream in = new ObjectInputStream(f);

            student = (Student) in.readObject();

            System.out.println(student);
            in.close();
            f.close();


        } catch (Exception e) {
        }


    }
}
