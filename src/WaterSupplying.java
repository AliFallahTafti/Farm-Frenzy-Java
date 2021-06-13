public class WaterSupplying {
    private int capacity;
    private int timeToFill;
    private int timeToOrder;

    public WaterSupplying(){
        this.capacity=5;
        this.timeToFill=3;
        this.timeToOrder=-1;
    }
    public void fill(){
        if(this.capacity==0){
            this.capacity=5;
            this.timeToOrder=-1;
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

    public void setTimeToOrder(int timeToOrder,Logger logger) {
        if(this.capacity!=0) {
            System.out.println("THE WELL ISN'T EMPTY");
            logger.printError("THE WELL ISN'T EMPTY");
        }else
             this.timeToOrder = timeToOrder;
    }

    public int getTimeToFill() {
        return timeToFill;
    }

    public void setTimeToFill(int timeToFill) {
        this.timeToFill = timeToFill;
    }
}