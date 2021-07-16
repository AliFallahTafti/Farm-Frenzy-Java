import java.util.Random;

public class Bear extends Animal{

    private int ProgressPerTime;
    private int lastTimeCaged;

    public Bear(){

        super("BEAR",5);
        this.ProgressPerTime=1;
        this.setHealth(4);
        this.setPrice(400);
    }

    @Override
    public boolean isFull() {
        return getHealth()==4;
    }

    public int getLastTimeCaged() {
        return lastTimeCaged;
    }

    public void setLastTimeCaged(int lastTimeCaged) {
        this.lastTimeCaged = lastTimeCaged;
    }
}
