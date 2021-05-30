import java.util.Random;

public class Lion extends Animal{
    private int ProgressPerTime;
    private int capacity;

    public Lion(){
        super("LION",5);
        this.ProgressPerTime=1;
        this.setHealth(3);
        this.setPrice(300);
        this.capacity=5;
    }
}
