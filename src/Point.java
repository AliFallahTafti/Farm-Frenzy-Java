import java.util.Random;

public class Point {

    private int x;
    private int y;
    private int maxX;
    private int maxY;
    private int minX;
    private int minY;

    public Point(){
        Random random=new Random();
        maxX=550;
        maxY=400;
        minX=200;
        minY=180;
        this.x=random.nextInt(maxX);
        this.y=random.nextInt(maxY);
        while (x>maxX||x<minX||y>maxY||y<minY){
            this.x=random.nextInt(maxX);
            this.y=random.nextInt(maxY);
        }
    }
    public String print(){
        return "["+x+" "+y+"]";
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }

    public int getMinX() {
        return minX;
    }

    public int getMinY() {
        return minY;
    }

    public void setY(int y) {
        this.y = y;
    }
    public boolean isEqual(Point a){
        if(this.x==a.getX()&&this.y==a.getY())
            return true;
        return false;
    }
    public double distance(Point a){
        return Math.sqrt((this.x-a.getX())*(this.x-a.getX())+(this.y-a.getY())*(this.y-a.getY()));
    }
    public boolean isNear(int x,int y,int amount){
        return Math.abs(x-this.x)<amount&&Math.abs(y-this.y)<amount;
    }
    public boolean isNear(Point point,int amount){
        return Math.abs(point.x-this.x)<amount&&Math.abs(point.y-this.y)<amount;
    }
}
