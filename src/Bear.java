import java.util.Random;

public class Bear extends Animal{
    private int ProgressPerTime;
    private int timesOfGettingCaged;
    private int TimesOfGettingCagedWhichIsLeft;
    private int sellingPrice;

    public Bear(){
        super("BEAR",5);
        this.ProgressPerTime=1;
        this.timesOfGettingCaged=4;
        this.TimesOfGettingCagedWhichIsLeft=4;
        this.sellingPrice=400;
    }
}
