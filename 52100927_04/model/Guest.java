package model;

import java.io.Serializable;

public class Guest implements Serializable{
    private String name;
    private String ssn;
    private String room;


    public Guest() {
    }

    


    public Guest(String name, String ssn, String room) {
        this.name = name;
        this.ssn = ssn;
        this.room = room;
    }




    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSsn() {
        return ssn;
    }
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }


    public String getRoom() {
        return room;
    }


    public void setRoom(String room) {
        this.room = room;
    }

    


    



}
