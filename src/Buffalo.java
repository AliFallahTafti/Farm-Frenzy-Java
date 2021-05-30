import java.util.Random;

public class Buffalo extends Animal{
    private int healthReduction;
    private Milk milk;
    private int timeForEgging;
    public Buffalo(){
        super("BUFFALO",2);
        this.setPrice(400);
        this.timeForEgging=5;
        this.setHealth(100);
        this.healthReduction=10;
    }
}
