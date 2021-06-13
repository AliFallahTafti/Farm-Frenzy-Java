public class Factories {

    private int price;
    private String name;
    private String inputProduct;
    private String outputProduct;
    private int timeToProduce;
    private int timeToOrder;

    public int getTimeToProduce() {
        return timeToProduce;
    }

    public Factories(int price, int timeToProduce,String name,String inputProduct,String outputProduct) {

        this.price = price;
        this.timeToProduce = timeToProduce;
        this.name=name;
        this.timeToOrder=-1;
        this.inputProduct=inputProduct;
        this.outputProduct=outputProduct;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getTimeToOrder() {
        return timeToOrder;
    }

    public String getInputProduct() {
        return inputProduct;
    }

    public String getOutputProduct() {
        return outputProduct;
    }

    public void setTimeToOrder(int timeToOrder) {
        this.timeToOrder = timeToOrder;
    }
}
