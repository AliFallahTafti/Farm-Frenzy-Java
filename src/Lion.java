import java.util.Random;

public class Lion extends Animal{

    private int ProgressPerTime;
    private int capacity;
    private int lastTimeCaged;

    public Lion(){

        super("LION",5);
        this.ProgressPerTime=1;
        this.setHealth(3);
        this.setPrice(300);
        this.capacity=5;
    }

    @Override
    public boolean isFull() {
        return getHealth()==3;
    }

    public int getLastTimeCaged() {
        return lastTimeCaged;
    }

    public void setLastTimeCaged(int lastTimeCaged) {
        this.lastTimeCaged = lastTimeCaged;
    }
}
