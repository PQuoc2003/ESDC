import java.io.Serializable;
import java.util.ArrayList;

public class Team implements Serializable {

    private ArrayList<Player> players;

    public Team() {
        players = new ArrayList<>();
    }


    public void addPlayer(Player player){
        this.players.add(player);
    }


    @Override
    public String toString() {
        return "Team [players=" + players + "]";
    }

    
    
    
    
    
}
