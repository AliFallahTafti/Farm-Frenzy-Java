import java.util.Random;

public class Chicken extends Animal{

    private int healthReduction;
    private Egg egg;
    private int timeForEgging;
    private int lastTime;

    public int getHealthReduction() {
        return healthReduction;
    }

    public Egg getEgg() {
        return egg;
    }

    public int getTimeForEgging() {
        return timeForEgging;
    }

    public void setEgg(Egg egg) {
        this.egg = egg;
    }

    public int getLastTime() {
        return lastTime;
    }

    public void setLastTime(int lastTime) {
        this.lastTime = lastTime;
    }

    public Chicken(int time){

        super("CHICKEN",2);
        this.setPrice(100);
        this.timeForEgging=2;
        this.setHealth(100);
        this.healthReduction=10;
        this.lastTime=time;
    }
}
