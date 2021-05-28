import java.util.Random;

public class Cat extends Animal{
    private int price;
    public Cat(){
        super("CAT",2);
        this.price=150;
    }

    public int getPrice() {
        return price;
    }
}
