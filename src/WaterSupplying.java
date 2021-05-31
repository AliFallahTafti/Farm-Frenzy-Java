public class WaterSupplying {

    private int capacity;
    private int timeToFill;

    public WaterSupplying(){
        this.capacity=5;
        this.timeToFill=3;
    }

    public void fill(){
        if(this.capacity==0){
            this.capacity=5;
        }
        else
            System.out.println("THE WELL ISN'T EMPTY");
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

    public int getTimeToFill() {
        return timeToFill;
    }

    public void setTimeToFill(int timeToFill) {
        this.timeToFill = timeToFill;
    }
}