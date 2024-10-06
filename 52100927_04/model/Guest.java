package model;

import java.io.Serializable;

public class Guest implements Serializable{
    private String name;
    private String ssn;


    public Guest() {
    }
    public Guest(String name, String ssn) {
        this.name = name;
        this.ssn = ssn;
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


    



}
