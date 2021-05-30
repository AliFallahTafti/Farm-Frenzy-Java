import java.util.Random;

public class Product {
    private int price;
    private int timeToDestroy;
    private String name;
    private Point point;
    private int capacity;

    public Product(String name,int capacity,int price,int timeToDestroy){
        Random random=new Random();
        this.point.setX(random.nextInt(6));
        this.point.setY(random.nextInt(6));
        this.name=name;
        this.capacity=capacity;
        this.timeToDestroy=timeToDestroy;
        this.price=price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public int getCapacity() {
        return capacity;
    }
}
