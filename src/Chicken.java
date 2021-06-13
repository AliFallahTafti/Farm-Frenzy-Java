import java.util.Random;

public class Chicken extends Animal{

    private int healthReduction;
    private Egg egg;
    private int timeForEgging;

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

    public Chicken(){

        super("CHICKEN",2);
        this.setPrice(100);
        this.timeForEgging=2;
        this.setHealth(100);
        this.healthReduction=10;
    }
}
