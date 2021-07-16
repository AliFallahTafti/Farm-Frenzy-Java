import java.util.Random;

public class Tiger extends Animal{

    private int ProgressPerTime;
    private int capacity;
    private int lastTimeCaged;
    private Point lastPoint;

    public Tiger(){

        super("TIGER",5);
        this.ProgressPerTime=2;
        this.setHealth(4);
        this.setPrice(500);
        this.capacity=5;
        this.lastPoint=new Point();
        this.lastPoint.setX(this.getPoint().getX());
        this.lastPoint.setY(this.getPoint().getY());
    }

    @Override
    public boolean isFull() {
        return getHealth()==4;
    }

    public int getLastTimeCaged() {
        return lastTimeCaged;
    }

    public void setLastPoint(Point lastPoint) {
        this.lastPoint = lastPoint;
    }

    public Point getLastPoint() {
        return lastPoint;
    }

    public void setLastTimeCaged(int lastTimeCaged) {
        this.lastTimeCaged = lastTimeCaged;
    }
}
