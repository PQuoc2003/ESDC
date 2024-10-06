public class Rectangle {

    private float length;
    private float width;


    public Rectangle(){
        this.length = 1f;
        this.width = 1f;
    }

    public Rectangle(float length, float width){
        this.length = length;
        this.width = width;
    }



    public float getArea(){
        return this.length * this.width;
    }

    public float getPerimeter(){
        return 2*(this.length + this.width);
    }



    public void setLength(float length) {
        this.length = length;
    }
    public float getWidth() {
        return width;
    }
    
    public void setWidth(float width) {
        this.width = width;
    }

    public float getLength() {
        return length;
    }


    @Override
    public String toString(){
        return "Rectangle[length=" + this.length + ", width=" + this.width + "]";
    }




    
}
