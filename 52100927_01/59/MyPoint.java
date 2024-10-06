public class MyPoint {
    private int x;
    private int y;

    public MyPoint() {
        this.x = 0;
        this.y = 0;
    }

    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distance(MyPoint myPoint) {
        return Math.sqrt(Math.pow((this.x - myPoint.getX()), 2) + Math.pow((this.y - myPoint.getY()), 2));
    }

    public double distance() {
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int[] getXY() {
        int[] point = { this.x, this.y };
        return point;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

}
