import java.util.Random;

public class Turkey extends Animal{

    private int healthReduction;
    private Feather feather;
    private int timeForEgging;
    private int lastTime;

    public int getHealthReduction() {
        return healthReduction;
    }

    public int getTimeForEgging() {
        return timeForEgging;
    }

    public Feather getFeather() {
        return feather;
    }

    public void setFeather(Feather feather) {
        this.feather = feather;
    }

    public int getLastTime() {
        return lastTime;
    }

    public void setLastTime(int lastTime) {
        this.lastTime = lastTime;
    }

    public Turkey(int time){

        super("TURKEY",2);
        this.setPrice(200);
        this.timeForEgging=3;
        this.setHealth(100);
        this.healthReduction=10;
        this.lastTime=time;
    }
}
