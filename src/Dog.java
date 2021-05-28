import java.util.Random;

public class Dog extends Animal{
    private int price;
    private int health;

    public Dog(){
        super("DOG",2);
        this.price=100;
        this.health=100;
    }

    public int getPrice() {
        return price;
    }
}
