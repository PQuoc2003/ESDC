import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeSerialize {
   public DeSerialize() {
   }

   public static void main(String[] var0) {
      Person p = null;

      try {
         FileInputStream f = new FileInputStream("person.ser");
         ObjectInputStream o = new ObjectInputStream(f);
         p = (Person)o.readObject();
         System.out.println("Success");
         System.out.println(p);
         o.close();
         f.close();
      } catch (Exception var4) {
         System.out.println("error");
      }

   }
}
