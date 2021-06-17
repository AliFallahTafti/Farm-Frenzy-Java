import java.util.ArrayList;

public class Truck {

    private ArrayList<Animal>animals;
    private ArrayList<Product>products;
    private int capacity;
    private int timeToOrder;
    private int timeToGo;
    private boolean order;

    public Truck(){
        this.capacity=15;
        this.timeToGo=10;
        this.timeToOrder=0;
        this.order=false;
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

    public boolean isOrder() {
        return order;
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

    public int getTimeToOrder() {
        return timeToOrder;
    }

    public void setTimeToOrder(int timeToOrder) {
        this.timeToOrder = timeToOrder;
    }

    public void setOrder(boolean order) {
        this.order = order;
    }

    public int getTimeToGo() {
        return timeToGo;
    }
}
