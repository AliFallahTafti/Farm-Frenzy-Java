import java.util.Random;

public class Bear extends Animal{

    private int ProgressPerTime;

    public Bear(){

        super("BEAR",5);
        this.ProgressPerTime=1;
        this.setHealth(4);
        this.setPrice(400);
    }
}
