import java.util.Random;

public class Lion extends Animal{
    private int ProgressPerTime;
    private int timesOfGettingCaged;
    private int TimesOfGettingCagedWhichIsLeft;
    private int sellingPrice;
    private int capacity;

    public Lion(){
        super("LION",5);
        this.ProgressPerTime=1;
        this.timesOfGettingCaged=3;
        this.TimesOfGettingCagedWhichIsLeft=3;
        this.sellingPrice=300;
        this.capacity=5;
    }
}
