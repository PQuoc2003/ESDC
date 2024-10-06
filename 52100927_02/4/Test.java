import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Test {
    public static void main(String[] args) {


        double[] testScore = {1, 2}; 


        Student student = new Student("Quoc", "ABC", testScore);


        try {
            FileOutputStream f = new FileOutputStream("student.ser");
            ObjectOutputStream out = new ObjectOutputStream(f);

            out.writeObject(student);

            out.close();
            f.close();


        } catch (Exception e) {
        }

    }
}
