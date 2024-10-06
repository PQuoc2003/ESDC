import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeSerialize {
    public static void main(String[] args) {


        Car car = null;


        try {
            FileInputStream f = new FileInputStream("car.ser");
            ObjectInputStream in = new ObjectInputStream(f);


            car = (Car) in.readObject();

            System.out.println(car);



            in.close();
            f.close();




        } catch (Exception e) {
            System.out.println("error");
        }
    }
}
