import java.util.Random;

public class Buffalo extends Animal{
    private int price;
    private int healthReduction;
    private int health;
    private Milk milk;
    private int timeForEgging;
    public Buffalo(){
        super("BUFFALO",2);
        this.price=price=400;
        this.timeForEgging=5;
        this.health=100;
        this.healthReduction=10;
    }

    public int getPrice() {
        return price;
    }
}
