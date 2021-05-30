import java.util.ArrayList;

public class Truck {
    private ArrayList<Animal>animals;
    private ArrayList<Product>products;
    private int capacity;
    private int timeToGo;

    public Truck(){
        this.capacity=15;
        this.timeToGo=10;
        animals=new ArrayList<>();
        products=new ArrayList<>();
    }

    public void updateCapacity(Product product){
        if(product.getCapacity()<=this.capacity){
            products.add(product);
            capacity-=product.getCapacity();
        }
    }
    public void updateCapacity(Animal animal){
        if(animal.getCapacity()<=this.capacity){
            animals.add(animal);
            capacity-=animal.getCapacity();
        }
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
}
