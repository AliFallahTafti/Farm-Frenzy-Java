import java.util.Random;

public class Turkey extends Animal{
    private int price;
    private int healthReduction;
    private int health;
    private Feather feather;
    private int timeForEgging;
    public Turkey(){
        super("TURKEY",2);
        this.price=price=200;
        this.timeForEgging=3;
        this.health=100;
        this.healthReduction=10;
    }


    public int getPrice() {
        return price;
    }
}
