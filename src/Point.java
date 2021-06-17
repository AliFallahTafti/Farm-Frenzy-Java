import java.util.Random;

public class Point {

    private int x;
    private int y;

    public Point(){
        Random random=new Random();
        this.x=random.nextInt(6);
        this.y=random.nextInt(6);
        this.x++;
        this.y++;
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
}
