import java.util.Random;

public class Animal {
    private Point point;
    private String name;
    private int capacity;
    private int price;
    private int health;

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Point getPoint() {
        return point;
    }
    public void setPoint(Point point) {
        this.point = point;
    }
}
