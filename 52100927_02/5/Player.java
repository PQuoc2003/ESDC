import java.io.Serializable;

public class Player implements Serializable{
    private String name;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player [name=" + name + "]";
    }


}