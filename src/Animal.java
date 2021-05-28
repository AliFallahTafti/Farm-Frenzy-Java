import java.util.Random;

public class Animal {
    private Point point;
    private String name;
    private int capacity;

    public Animal(String name,int capacity){
        Random random=new Random();
        this.point.setX(random.nextInt(6));
        this.point.setY(random.nextInt(6));
        this.name=name;
        this.capacity=capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public Point getPoint() {
        return point;
    }
    public void setPoint(Point point) {
        this.point = point;
    }
}
