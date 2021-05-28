import java.util.ArrayList;

public class Storeroom {
    private int capacity;
    private int maxCapacity=30;
    private ArrayList<Product>products;
    private ArrayList<Animal>animals;

    public Storeroom(){
        this.capacity=0;
        animals=new ArrayList<>();
        products=new ArrayList<>();
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
