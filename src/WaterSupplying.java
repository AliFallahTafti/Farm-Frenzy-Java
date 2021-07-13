public class WaterSupplying {
    private int capacity;
    private int timeToFill;
    private int timeToOrder;
    private boolean order;

    public WaterSupplying(){
        this.capacity=5;
        this.timeToFill=3;
        this.timeToOrder=0;
        this.order=false;
    }
    public void fill(){
        if(this.capacity==0){
            this.capacity=5;
            this.order=false;
        }
    }
    public void unFill(){
        --this.capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getTimeToOrder() {
        return timeToOrder;
    }

    public void setTimeToOrder(int timeToOrder) {
            this.timeToOrder = timeToOrder;
            this.order=true;
    }

    public int getTimeToFill() {
        return timeToFill;
    }

    public boolean isOrder() {
        return order;
    }

    public void setTimeToFill(int timeToFill) {
        this.timeToFill = timeToFill;
    }
}