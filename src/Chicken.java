import java.util.Random;

public class Chicken extends Animal{
    private int price;
    private int healthReduction;
    private int health;
    private Egg egg;
    private int timeForEgging;
    public Chicken(){
        super("CHICKEN",2);
        this.price=price=100;
        this.timeForEgging=2;
        this.health=100;
        this.healthReduction=10;
    }


    public int getPrice() {
        return price;
    }
}
