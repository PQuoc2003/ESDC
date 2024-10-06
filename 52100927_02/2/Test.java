import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Test {
    public static void main(String[] args) {

        Car car = new Car("Vietnam", "VF3", 2020);

        try {
            FileOutputStream f = new FileOutputStream("car.ser");
            ObjectOutputStream o = new ObjectOutputStream(f);

            o.writeObject(car);
            o.close();
            f.close();
        } catch (Exception e) {
            System.out.println("error");
        }

    }
}
