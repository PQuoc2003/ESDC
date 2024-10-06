import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeSerialize {
    public static void main(String[] args) {
        Team team = null;

        try {
            FileInputStream f = new FileInputStream("team.ser");
            ObjectInputStream in = new ObjectInputStream(f);


            team = (Team)in.readObject();
            System.out.println(team);
            in.close();
            f.close();



        } catch (Exception e) {
        }



    }
}
