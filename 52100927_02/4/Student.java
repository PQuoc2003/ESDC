import java.io.Serializable;
import java.util.Arrays;

public class Student implements Serializable{

    private String name;

    private String id;

    private double[] testScore;

    public Student(String name, String id, double[] testScore) {
        this.name = name;
        this.id = id;
        this.testScore = testScore;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", id=" + id + ", testScore=" + Arrays.toString(testScore) + "]";
    }


    


}