import java.util.Random;

public class Tiger extends Animal{
    private int ProgressPerTime;
    private int capacity;

    public Tiger(){
        super("TIGER",5);
        this.ProgressPerTime=2;
        this.setHealth(4);
        this.setPrice(500);
        this.capacity=5;
    }
}
