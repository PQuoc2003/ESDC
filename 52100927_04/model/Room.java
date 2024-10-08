package model;

import java.io.Serializable;

public class Room implements Serializable {

    private String type;
    private int totalRoom;
    private int remainRoom;
    private int price;

    public Room() {
    }

    public Room(String type, int totalRoom, int remainRoom, int price) {
        this.type = type;
        this.totalRoom = totalRoom;
        this.remainRoom = remainRoom;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTotalRoom() {
        return totalRoom;
    }

    public void setTotalRoom(int totalRoom) {
        this.totalRoom = totalRoom;
    }

    public int getRemainRoom() {
        return remainRoom;
    }

    public void setRemainRoom(int remainRoom) {
        this.remainRoom = remainRoom;
    }

    public void checkout() {
        if (this.remainRoom > 0)
            this.remainRoom -= 1;
    }

    public void returnRoom() {
        if (this.remainRoom > totalRoom) {
            this.remainRoom += 1;
        }
    }

    @Override
    public String toString() {
        return  this.remainRoom + " rooms of type " + this.type+ " are available for " + this.price + " Euros per night";
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
