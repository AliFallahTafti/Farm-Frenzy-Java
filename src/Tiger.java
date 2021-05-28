import java.util.Random;

public class Tiger extends Animal{
    private int ProgressPerTime;
    private int timesOfGettingCaged;
    private int TimesOfGettingCagedWhichIsLeft;
    private int sellingPrice;
    private int capacity;

    public Tiger(){
        super("TIGER",5);
        this.ProgressPerTime=2;
        this.timesOfGettingCaged=4;
        this.TimesOfGettingCagedWhichIsLeft=4;
        this.sellingPrice=500;
        this.capacity=5;
    }
}
