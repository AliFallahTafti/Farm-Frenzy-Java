import java.util.Random;

public class Buffalo extends Animal{

    private int healthReduction;
    private Milk milk;
    private int timeForEgging;
    private int lastTime;

    public int getHealthReduction() {
        return healthReduction;
    }

    public int getTimeForEgging() {
        return timeForEgging;
    }

    public Milk getMilk() {
        return milk;
    }

    public void setMilk(Milk milk) {
        this.milk = milk;
    }

    public int getLastTime() {
        return lastTime;
    }

    public void setLastTime(int lastTime) {
        this.lastTime = lastTime;
    }

    public Buffalo(int time){

        super("BUFFALO",2);
        this.setPrice(400);
        this.timeForEgging=5;
        this.setHealth(100);
        this.healthReduction=10;
        this.lastTime=time;
    }
}
