public class Circle{
    private double radius;
    private String color;


    public Circle(){
        this.radius = 1;
        this.color = "red";
    }

    public Circle(double radius){
        this.radius = radius;
        this.color = "red";
    }

    public double getRadius(){
        return this.radius;
    }

    public double getArea(){
        return Math.PI * this.radius * this.radius;
    }





}