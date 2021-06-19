public class Factories {

    private int price;
    private String name;
    private String inputProduct;
    private String outputProduct;
    private int timeToProduce;
    private int timeToOrder;
    private int upgradePrice;
    private boolean order;
    private int upgradeMood;  //0 not   1 mood a   2 mood b
    private boolean upgrade;

    public int getTimeToProduce() {
        return timeToProduce;
    }

    public Factories(int price, int timeToProduce,String name,String inputProduct,String outputProduct) {

        this.price = price;
        this.timeToProduce = timeToProduce;
        this.name=name;
        this.timeToOrder=0;
        this.upgradePrice=100;
        this.upgradeMood=1;
        this.upgrade=false;
        this.order=false;
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

    public boolean isOrder() {
        return order;
    }

    public void setOrder(boolean order) {
        this.order = order;
    }

    public void setTimeToOrder(int timeToOrder) {
        this.timeToOrder = timeToOrder;
    }

    public int getUpgradeMood() {
        return upgradeMood;
    }

    public void setUpgradeMood(int upgrade) {
        this.upgradeMood = upgrade;
    }

    public int getUpgradePrice() {
        return upgradePrice;
    }

    public void setTimeToProduce(int timeToProduce) {
        this.timeToProduce = timeToProduce;
    }

    public boolean isUpgrade() {
        return upgrade;
    }

    //method
    public void upgrade(){
        this.upgrade=true;
    }
}
