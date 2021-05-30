import java.util.ArrayList;

public class Storeroom {
    private int capacity;
    private ArrayList<Product>products;
    private ArrayList<Animal>animals;

    public Storeroom(){
        this.capacity=30;
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
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
