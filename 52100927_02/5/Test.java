import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Test {
    public static void main(String[] args) {
        Team team = new Team();

        for (int i = 0; i < 5; i++) {

            Player player = new Player("player_"+i);

            team.addPlayer(player);
            
        }

        try {
            FileOutputStream f = new FileOutputStream("team.ser");
            ObjectOutputStream out = new ObjectOutputStream(f);
            
            out.writeObject(team);
            
            out.close();
            f.close();
        } catch (Exception e) {
        }



    }
}
