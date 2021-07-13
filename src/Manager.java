//import jdk.nashorn.internal.runtime.JSONFunctions;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
//import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;

    public class Manager {

        private User user;
        private Mission mission;
        private int level;
        private Storeroom storeroom;
        private WaterSupplying waterSupplying;
        private Truck truck;
        private Logger logger;
        private ArrayList<User>users;
        private ArrayList<Animal>animals;
        private ArrayList<Grass>grasses;
        private ArrayList<Product>products;
        private ArrayList<Mission>missions;
        private ArrayList<Factories>factories;
        private int [][] screen;
        private int timeIndex;
        private int loginStatus;  //0login    1logout     2exit      3menu
        private int gameStatus;    //0 GameOver    2Winning     1InGame


    public Manager(){
        this.users=new ArrayList<>();
        this.animals=new ArrayList<>();
        this.missions=new ArrayList<>();
        this.grasses=new ArrayList<>();
        this.factories=new ArrayList<>();
        this.storeroom=new Storeroom();
        this.logger=new Logger();
        this.waterSupplying=new WaterSupplying();
        this.mission=new Mission();
        this.products=new ArrayList<>();
        this.screen=new int[6][6];
        this.truck=new Truck();
        this.loginStatus=1;
        this.timeIndex=0;
    }

    //getter
    public ArrayList<User> getUsers() {
        return users;
    }
    public int getLoginStatus() {
        return loginStatus;
    }
    public ArrayList<Mission> getMissions() {
            return missions;
        }
    public User getUser() {
            return user;
        }
    public WaterSupplying getWaterSupplying() {
            return waterSupplying;
    }

        //method
    public int login(String username,String password){

        loadUsers();
        if(users!=null) {
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getUsername().equals(username)) {
                    if (users.get(i).getPassword().equals(password)) {
                        logger.printHeader(users.get(i));
                        logger.printInfo("LOGIN SUCCESSFULLY!!");
                        this.user = users.get(i);
                        this.loginStatus = 3;
                        //todo
                        return 1;
                    }
                    else {
                        logger.printError("WRONG PASSWORD");
                        return 0;
                    }
                }
            }
        }
        logger.printError("THERE ISN'T ANY USER WITH USER NAME "+username);
        return 2;
    }

    public int signup(String username,String password){

        loadUsers();
        if(users!=null) {
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getUsername().equals(username)) {
                    logger.printError("ALREADY THERE IS A USER WITH THIS USERNAME!");
                    return 0;
                }
            }
        }
        else{
            users=new ArrayList<>();
        }
        loginStatus=3;
        User user1 = new User(username, password);
        logger.printHeader(user1);
        logger.printInfo("SIGNUP SUCCESSFULLY!!");
        users.add(user1);
        this.user = user1;
        //todo
        return 1;
    }

    public void exit(){
        logger.printInfo("THE USER EXIT FROM GAME");
        this.loginStatus=2;
        saveUsers();
    }

    public int getNumberOfFactory(){
        int counter=0;
        Set<String> productKeys=mission.productTasks.keySet();
        for(String productKey: productKeys){
            if(productKey.equals("POWDER")||productKey.equals("BREAD")||productKey.equals("CLOTHES")||productKey.equals("DRESS")
            ||productKey.equals("ICECREAM")||productKey.equals("PACKEDMILK")){
                ++counter;
            }
        }
        return counter;
    }
    public void start(int level) throws CloneNotSupportedException {
        loadMissions();
        if(user.getLevel()>=level) {
            logger.printInfo("START LEVEL :"+level);
            this.mission= (Mission) missions.get(level-1).clone();
            this.user.setCoins(mission.coin);
            this.loginStatus = 0;
            this.gameStatus=1;
            this.timeIndex=0;
            this.level=level;
            this.grasses=new ArrayList<>();
            this.factories=new ArrayList<>();
            this.storeroom=new Storeroom();
            this.waterSupplying=new WaterSupplying();
            this.products=new ArrayList<>();
            this.screen=new int[6][6];
            this.truck=new Truck();
            this.animals=new ArrayList<>();
        }
        else {
            logger.printAlarm("PREVIOUS LEVELS AREN'T DONE!");
        }
    }

    public void buy(String name){
        if(name.equals("CHICKEN")){
            Chicken chicken=new Chicken(timeIndex);
            if(this.user.getCoins()>=chicken.getPrice()) {
                animals.add(chicken);
                storeroom.getAnimals().add(chicken);
                this.user.setCoins(this.user.getCoins()-chicken.getPrice());
                updateMission(chicken);
                System.out.println("YOU BUY A CHICKEN!");
                logger.printInfo("YOU BUY A CHICKEN!");
            }
            else {
                System.out.println("NO ENOUGH MONEY!");
                logger.printError("NO ENOUGH MONEY!");
            }
        }
        else if(name.equals("TURKEY")){
            Turkey turkey=new Turkey(timeIndex);
            if(this.user.getCoins()>=turkey.getPrice()) {
                animals.add(turkey);
                storeroom.getAnimals().add(turkey);
                this.user.setCoins(this.user.getCoins()-turkey.getPrice());
                updateMission(turkey);
                System.out.println("YOU BUY A TURKEY!");
                logger.printInfo("YOU BUY A TURKEY!");
            }
            else {
                System.out.println("NO ENOUGH MONEY!");
                logger.printError("NO ENOUGH MONEY!");
            }
        }
        else if(name.equals("BUFFALO")){
            Buffalo buffalo=new Buffalo(timeIndex);
            if(this.user.getCoins()>=buffalo.getPrice()) {
                animals.add(buffalo);
                storeroom.getAnimals().add(buffalo);
                this.user.setCoins(this.user.getCoins()-buffalo.getPrice());
                updateMission(buffalo);
                System.out.println("YOU BUY A BUFFALO!");
                logger.printInfo("YOU BUY A BUFFALO!");
            }
            else {
                System.out.println("NO ENOUGH MONEY!");
                logger.printError("NO ENOUGH MONEY!");
            }
        }
        else if(name.equals("CAT")) {
            Cat cat = new Cat();
            if (this.user.getCoins() >= cat.getPrice()) {
                animals.add(cat);
                storeroom.getAnimals().add(cat);
                this.user.setCoins(this.user.getCoins() - cat.getPrice());
                updateMission(cat);
                System.out.println("YOU BUY A CAT!");
                logger.printInfo("YOU BUY A CAT!");
            }
            else{
                System.out.println("NO ENOUGH MONEY!");
                logger.printError("NO ENOUGH MONEY!");
            }
        }
        else if(name.equals("DOG")){
            Dog dog=new Dog();
            if(this.user.getCoins()>=dog.getPrice()) {
                animals.add(dog);
                storeroom.getAnimals().add(dog);
                this.user.setCoins(this.user.getCoins()-dog.getPrice());
                updateMission(dog);
                System.out.println("YOU BUY A DOG!");
                logger.printInfo("YOU BUY A DOG!");
            }
            else {
                System.out.println("NO ENOUGH MONEY!");
                logger.printError("NO ENOUGH MONEY!");
            }
        }
        else {
            System.out.println("THERE ISN'T ANY ANIMAL WITH NAME :" + name);
            logger.printAlarm("THERE ISN'T ANY ANIMAL WITH NAME :" + name);
        }
    }

    public int pickup(int x,int y){
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getPoint().getX()==x&&products.get(i).getPoint().getY()==y){
                if(storeroom.getCapacity()>=products.get(i).getCapacity()) {
                    updateMission(products.get(i));
                    storeroom.getProducts().add(products.get(i));
                    storeroom.setCapacity(storeroom.getCapacity() - products.get(i).getCapacity());
                    products.remove(i);
                    logger.printInfo("THE PRODUCT WAS PICKED UP!");
                    System.out.println("THE PRODUCT WAS PICKED UP!");
                    return 1;
                }
            }
        }
        logger.printError("THERE ISN'T ANY PRODUCT!");
        System.out.println("THERE ISN'T ANY PRODUCT!");
        return 0;
    }

    public void plant(int x,int y){
        if(this.waterSupplying.getCapacity()>0) {
            Grass grass = new Grass(x, y);
            this.grasses.add(grass);
            this.waterSupplying.unFill();
            System.out.println("YOU PLANT A GRASS!");
            logger.printInfo("YOU PLANT A GRASS!");
        }else {
            System.out.println("NO ENOUGH WATER!");
            logger.printError("NO ENOUGH WATER!");
        }
    }

    public int well(){
        if(waterSupplying.getCapacity()!=0) {
            logger.printError("THE WELL ISN'T EMPTY");
            return 0;
        }else {
            logger.printInfo("THE WELL STARTS FILLING!");
            waterSupplying.setTimeToOrder(timeIndex);
            return 1;
        }
    }

    public int build(String name){
        for (int i = 0; i < this.factories.size(); i++) {
            if(factories.get(i).getName().equals(name)){
                logger.printError("ALREADY THERE IS A FACTORY WITH NAME "+name);
                System.out.println("ALREADY THERE IS A FACTORY WITH NAME "+name);
                return 0;
            }
        }
        if(name.equals("BAKERY")){
            Bakery bakery=new Bakery();
            if(this.user.getCoins()>=bakery.getPrice()){
                this.user.setCoins(this.user.getCoins()-bakery.getPrice());
                factories.add(bakery);
                System.out.println("YOU BUILD A BAKERY");
                logger.printInfo("YOU BUILD A BAKERY");
                return 1;
            }else{
                System.out.println("NO ENOUGH MONEY");
                logger.printError("NO ENOUGH MONEY");
                return 0;
            }
        }else if(name.equals("POWDERPLANT")){
            PowderPlant powderPlant=new PowderPlant();
            if(this.user.getCoins()>=powderPlant.getPrice()){
                this.user.setCoins(this.user.getCoins()-powderPlant.getPrice());
                factories.add(powderPlant);
                System.out.println("YOU BUILD A POWDERPLANT");
                logger.printInfo("YOU BUILD A POWDERPLANT");
                return 1;
            }else{
                System.out.println("NO ENOUGH MONEY");
                logger.printError("NO ENOUGH MONEY");
                return 0;
            }
        }else if(name.equals("ICECREAMFACTORY")){
            IceCreamFactory iceCreamFactory=new IceCreamFactory();
            if(this.user.getCoins()>=iceCreamFactory.getPrice()){
                this.user.setCoins(this.user.getCoins()-iceCreamFactory.getPrice());
                factories.add(iceCreamFactory);
                System.out.println("YOU BUILD A ICECREAMFACTORY");
                logger.printInfo("YOU BUILD A ICECREAMFACTORY");
                return 1;
            }else{
                System.out.println("NO ENOUGH MONEY");
                logger.printError("NO ENOUGH MONEY");
                return 0;
            }
        }else if(name.equals("WEAVING")){
            Weaving weaving=new Weaving();
            if(this.user.getCoins()>=weaving.getPrice()){
                this.user.setCoins(this.user.getCoins()-weaving.getPrice());
                factories.add(weaving);
                System.out.println("YOU BUILD A WEAVING");
                logger.printInfo("YOU BUILD A WEAVING");
                return 1;
            }else{
                System.out.println("NO ENOUGH MONEY");
                logger.printError("NO ENOUGH MONEY");
                return 0;
            }
        }else if(name.equals("SEWING")){
            Sewing sewing=new Sewing();
            if(this.user.getCoins()>=sewing.getPrice()){
                this.user.setCoins(this.user.getCoins()-sewing.getPrice());
                factories.add(sewing);
                System.out.println("YOU BUILD A SEWING");
                logger.printInfo("YOU BUILD A SEWING");
                return 1;
            }else{
                System.out.println("NO ENOUGH MONEY");
                logger.printError("NO ENOUGH MONEY");
                return 0;
            }
        }else if(name.equals("MILKPACKING")){
            MilkPacking milkPacking=new MilkPacking();
            if(this.user.getCoins()>=milkPacking.getPrice()){
                this.user.setCoins(this.user.getCoins()-milkPacking.getPrice());
                factories.add(milkPacking);
                System.out.println("YOU BUILD A MILKPACKING");
                logger.printInfo("YOU BUILD A MILKPACKING");
                return 1;
            }else{
                System.out.println("NO ENOUGH MONEY");
                logger.printError("NO ENOUGH MONEY");
                return 0;
            }
        }else{
            System.out.println("INVALID FACTORY NAME!");
            logger.printError("INVALID FACTORY NAME!");
            return 0;
        }
    }

    public int work(String name){
        int index1=-1,index2=-1;
        for (int i = 0; i < factories.size(); i++) {
            if(factories.get(i).getName().equals(name)&&!factories.get(i).isOrder()){
                for (int j = 0; j < storeroom.getProducts().size(); j++) {
                    if(!factories.get(i).isUpgrade()&&storeroom.getProducts().get(j).getName().equals(factories.get(i).getInputProduct())){
                        factories.get(i).setTimeToOrder(timeIndex);
                        factories.get(i).setOrder(true);
                        storeroom.getProducts().remove(j);
                        logger.printInfo(name+" FACTORY STARTS WORKING!");
                        System.out.println(name+" FACTORY STARTS WORKING!");
                        return 1;
                    }else if(factories.get(i).isUpgrade()&&storeroom.getProducts().get(j).getName().equals(factories.get(i).getInputProduct())){
                        if(index1==-1)
                            index1=i;
                        else if(index2==-1)
                            index2=i;
                    }
                }
            }else if(factories.get(i).getName().equals(name)&&factories.get(i).isOrder()){
                logger.printError("THE "+name+" IS ALREADY WORKING!");
                System.out.println("THE "+name+" IS ALREADY WORKING!");
                return 0;
            }
            if(factories.get(i).getName().equals(name)&&factories.get(i).isUpgrade()){
                if(index1!=-1&&index2!=-1){
                    factories.get(i).setTimeToOrder(timeIndex);
                    if(factories.get(i).getUpgradeMood()==2)
                        factories.get(i).setTimeToProduce(factories.get(i).getTimeToProduce()*2);
                    factories.get(i).setOrder(true);
                    factories.get(i).setUpgradeMood(1);
                    if(index1<index2) {
                        storeroom.getProducts().remove(index2);
                        storeroom.getProducts().remove(index1);
                    }else{
                        storeroom.getProducts().remove(index1);
                        storeroom.getProducts().remove(index2);
                    }
                    logger.printInfo(name+" FACTORY STARTS WORKING!");
                    System.out.println(name+" FACTORY STARTS WORKING!");
                    return 1;
                }else if(index1!=-1&&index2==-1){
                    factories.get(i).setTimeToOrder(timeIndex);
                    if(factories.get(i).getUpgradeMood()==1)
                    factories.get(i).setTimeToProduce(factories.get(i).getTimeToProduce()/2);
                    factories.get(i).setOrder(true);
                    factories.get(i).setUpgradeMood(2);
                    storeroom.getProducts().remove(index1);
                    logger.printInfo(name+" FACTORY STARTS WORKING!");
                    System.out.println(name+" FACTORY STARTS WORKING!");
                    return 1;
                }
            }
        }
        logger.printError("INVALID FACTORY NAME OR NO INPUT PRODUCT!");
        System.out.println("INVALID FACTORY NAME OR NO INPUT PRODUCT!");
        return 0;
    }

    public int upgrade(String name){
        for (int i = 0; i < factories.size(); i++) {
            if (factories.get(i).getName().equals(name)) {
                if(factories.get(i).getUpgradePrice()<=this.user.getCoins()) {
                    factories.get(i).upgrade();
                    this.user.setCoins(this.user.getCoins()-factories.get(i).getUpgradePrice());
                    logger.printInfo(name+" FACTORY IS UPGRADED!");
                    System.out.println(name+" FACTORY IS UPGRADED!");
                    return 1;
                }else{
                    logger.printError("NO ENOUGH MONEY!");
                    System.out.println("NO ENOUGH MONEY!");
                    return 0;
                }
            }
        }
        logger.printError("THERE ISN'T ANY FACTORY WITH NAME "+name);
        System.out.println("THERE ISN'T ANY FACTORY WITH NAME "+name);
        return 0;
    }

    public int cage(int x,int y){
        for (int i = 0; i < animals.size(); i++) {
            if(animals.get(i).getName().equals("BEAR")||animals.get(i).getName().equals("LION")||animals.get(i).getName().equals("TIGER")){
                if(animals.get(i).getPoint().getX()==x&&animals.get(i).getPoint().getY()==y){
                    if(animals.get(i).getHealth()==1){
                        if(storeroom.getCapacity()>=animals.get(i).getCapacity()) {
                            storeroom.getAnimals().add(animals.get(i));
                            logger.printInfo("YOU KILLED THE ENEMY!");
                            System.out.println("YOU KILLED THE ENEMY!");
                            animals.remove(i);
                            --i;
                            if(i<0)
                                i=0;
                        }else{
                            logger.printError("NO ENOUGH ROOM!");
                            System.out.println("NO ENOUGH ROOM!");
                        }
                    }else {
                        animals.get(i).setHealth(animals.get(i).getHealth() - 1);
                        if(animals.get(i).getName().equals("BEAR"))
                            ((Bear)animals.get(i)).setLastTimeCaged(timeIndex);
                        else if(animals.get(i).getName().equals("LION"))
                            ((Lion)animals.get(i)).setLastTimeCaged(timeIndex);
                        else if(animals.get(i).getName().equals("TIGER"))
                            ((Tiger)animals.get(i)).setLastTimeCaged(timeIndex);
                        System.out.println("YOU ATTACKED THE ENEMY");
                        logger.printInfo("YOU ATTACKED THE ENEMY");
                    }
                    return 1;
                }
            }
        }
        logger.printError("THERE ISN'T ANY ENEMIES THERE!");
        System.out.println("THERE ISN'T ANY ENEMIES THERE!");
        return 0;
    }

    public void turn(int n){

        timeIndex += n;
        UpdateWaterSupplying(n);
        UpdateTruck(n);
        UpdateWildAnimals(n);
        //UpdateAnimalsAndTheirProducts(n);
        UpdateAnimalsAndTheirProducts1(n);
        UpdateUnpickedProducts();
        UpdateFactoriesAndTheirProducts(n);
        //inquiry();
        updateGame();
    }


    public void UpdateUnpickedProducts(){
        for (int i = 0; i < products.size(); i++) {
                if(timeIndex-products.get(i).getTimeProduced()>=products.get(i).getTimeToDestroy()){
                    products.remove(i);
                    --i;
                }
        }
    }

    public void UpdateWildAnimals(int n){
        Set<String> wildAnimals=mission.wildAnimals.keySet();
        String name="";
        for(String wildAnimal: wildAnimals){
            if(mission.wildAnimals.get(wildAnimal)<=timeIndex){
                if(wildAnimal.equals("BEAR")){
                    name="BEAR";
                    Bear bear=new Bear();
                    this.animals.add(bear);
                    logger.printInfo("ENEMY IS ATTACKING");
                }else if(wildAnimal.equals("LION")){
                    name="LION";
                    Lion lion=new Lion();
                    this.animals.add(lion);
                    logger.printInfo("ENEMY IS ATTACKING");
                }else if(wildAnimal.equals("TIGER")){
                    name="TIGER";
                    Tiger tiger=new Tiger();
                    this.animals.add(tiger);
                    logger.printInfo("ENEMY IS ATTACKING");
                }
            }
        }
        if(!name.equals("")){
           mission.wildAnimals.remove(name);
        }
        for (int i = 0; i < this.animals.size(); i++) {
            if((animals.get(i).getName().equals("BEAR")&&((Bear)animals.get(i)).getLastTimeCaged()!=timeIndex-1)||(animals.get(i).getName().equals("LION")&&((Lion)animals.get(i)).getLastTimeCaged()!=timeIndex-1)
            ||(animals.get(i).getName().equals("TIGER")&&((Tiger)animals.get(i)).getLastTimeCaged()!=timeIndex-1)){
                animals.get(i).setHealth(animals.get(i).getHealth()+n);
                if(animals.get(i).getHealth()>4)
                    animals.get(i).setHealth(4);
            }
        }
    }

    public void UpdateTruck(int n){
        if(this.truck.isOrder()&&this.timeIndex-this.truck.getTimeToOrder()>=this.truck.getTimeToGo()){
            for (int i = 0; i < truck.getProducts().size(); i++) {
                this.user.setCoins(this.user.getCoins()+truck.getProducts().get(i).getPrice());
            }
            for (int i = 0; i < truck.getAnimals().size(); i++) {
                this.user.setCoins(this.user.getCoins()+truck.getAnimals().get(i).getPrice());
            }
            truck.setCapacity(15);
            truck.setOrder(false);
            truck.getProducts().clear();
            truck.getAnimals().clear();
            logger.printInfo("THE TRUCK COMES BACK");
        }
    }

    public void UpdateWaterSupplying(int n){
        if(this.waterSupplying.isOrder()&&this.timeIndex-this.waterSupplying.getTimeToOrder()>=this.waterSupplying.getTimeToFill()){
            this.waterSupplying.fill();
            logger.printInfo("THE WELL IS FILLED NOW!");
        }
    }

//     update animals and their products

    private int k_mod_timeForEgging = 0;

    public void UpdateAnimalsAndTheirProducts(int n) {

        int n_n = n;

        for (int i = 0; i < animals.size(); ++i) {

            if ("CHICKEN".equals(animals.get(i).getName())) {

                if (n >= ((Chicken) animals.get(i)).getTimeForEgging()) {

                    int k = n + k_mod_timeForEgging;

                    while (k >= ((Chicken) animals.get(i)).getTimeForEgging()) {

                        k -= ((Chicken) animals.get(i)).getTimeForEgging();
                        Egg egg = new Egg(timeIndex);
                        products.add(egg);
                    }

                    k_mod_timeForEgging = k % ((Chicken) animals.get(i)).getTimeForEgging();
                }

                int health = animals.get(i).getHealth();
                health -= n * ((Chicken) animals.get(i)).getHealthReduction();

                if (health > 0) {

                    if(health > 50) {

                        // wisely walk
                        while(n_n > 0){

                            RandomWalk(animals.get(i));
                            n_n--;
                        }
                    }

                    else {

                        // random walk
                        while(n_n > 0){

                            RandomWalk(animals.get(i));
                            n_n--;

                            for (Grass grass : grasses) {

                                if(grass.getPoint().equals(animals.get(i).getPoint())) {

                                    grasses.remove(grass);
                                    animals.get(i).setHealth(100);
                                }
                            }
                        }
                    }
                }

                else animals.remove(animals.get(i));
            }

            else if ("TURKEY".equals(animals.get(i).getName())) {

                if (n >= ((Turkey) animals.get(i)).getTimeForEgging()) {

                    int k = n + k_mod_timeForEgging;

                    while (k >= ((Turkey) animals.get(i)).getTimeForEgging()) {

                        k -= ((Turkey) animals.get(i)).getTimeForEgging();
                        Feather feather = new Feather(timeIndex);
                        products.add(feather);
                    }
                }

                int health = animals.get(i).getHealth();
                health -= n * ((Turkey) animals.get(i)).getHealthReduction();

                if (health > 0) {

                    if(health > 50){

                        // wisely walk
                        while(n_n > 0){

                            RandomWalk(animals.get(i));
                            n_n--;
                        }
                    }

                    else {

                        // random walk
                        while(n_n > 0){

                            RandomWalk(animals.get(i));
                            n_n--;


                            for (Grass grass : grasses) {

                                if(grass.getPoint().equals(animals.get(i).getPoint())) {

                                    grasses.remove(grass);
                                    animals.get(i).setHealth(100);
                                }
                            }
                        }
                    }
                }

                else animals.remove(animals.get(i));
            }

            else if ("BUFFALO".equals(animals.get(i).getName())) {

                if (n >= ((Buffalo) animals.get(i)).getTimeForEgging()) {

                    int k = n + k_mod_timeForEgging;

                    while (k >= ((Buffalo) animals.get(i)).getTimeForEgging()) {

                        k -= ((Buffalo) animals.get(i)).getTimeForEgging();
                        Milk milk = new Milk(timeIndex);
                        products.add(milk);
                    }

                    k_mod_timeForEgging = k % ((Buffalo) animals.get(i)).getTimeForEgging();
                }

                int health = animals.get(i).getHealth();
                health -= n * ((Buffalo) animals.get(i)).getHealthReduction();

                if (health > 0) {

                    if (health > 50) {

                        // wisely walk
                        while (n_n > 0) {

                            RandomWalk(animals.get(i));
                            n_n--;
                        }
                    }

                    else {

                        // random walk
                        while (n_n > 0) {

                            RandomWalk(animals.get(i));
                            n_n--;


                            for (Grass grass : grasses) {

                                if(grass.getPoint().equals(animals.get(i).getPoint())) {

                                    grasses.remove(grass);
                                    animals.get(i).setHealth(100);
                                }
                            }
                        }
                    }
                }

                else animals.remove(animals.get(i));
            }

            else if("DOG".equals(animals.get(i).getName())){

                int health = animals.get(i).getHealth();

                if(health > 0) {

                    while(n_n > 0) {

                        RandomWalk(animals.get(i));
                        n_n--;

                        for (Animal animal : animals) {

                            if(animal.getName().equals("LION") || animal.getName().equals("BEAR") || animal.getName().equals("TIGER")) {

                                if(animal.getPoint().equals(animals.get(i).getPoint())) {

                                    animals.remove(i);
                                    animals.remove(animal);
                                }
                            }
                        }
                    }
                }

                else animals.remove(animals.get(i));
            }

            else if("CAT".equals(animals.get(i).getName())){

                int health = animals.get(i).getHealth();

                if(health > 0) {

                    while(n_n > 0) {

                        RandomWalk(animals.get(i));
                        n_n--;

                        for (Product product : products) {

                            if(product.getPoint().equals(animals.get(i).getPoint())){

                                // product should go to store room
                            }
                        }
                    }
                }

                else animals.remove(animals.get(i));
            }

            /////////////////////////////////////////////////////////////// Wild Animals ...

            else if("LION".equals(animals.get(i).getName())){

                while(n_n > 0){

                    RandomWalk(animals.get(i));
                    n_n--;

                    for (Animal animal : animals) {

                        if(animal.getName().equals("CHICKEN") || animal.getName().equals("TURKEY") || animal.getName().equals("BUFFALO")){

                            if(animal.getPoint().equals(animals.get(i).getPoint())) {

                                animals.remove(animal);
                            }
                        }
                    }
                }
            }

            else if("BEAR".equals(animals.get(i).getName())) {

                while(n_n > 0){

                    RandomWalk(animals.get(i));
                    n_n--;

                    for (Animal animal : animals) {

                        if (animal.getName().equals("CHICKEN") || animal.getName().equals("TURKEY") || animal.getName().equals("BUFFALO")) {

                            if (animal.getPoint().equals(animals.get(i).getPoint())) {

                                animals.remove(animal);
                            }
                        }
                    }
                }
            }

            else if("TIGER".equals(animals.get(i).getName())){

                while(n_n > 0){

                    // random walk twice
                    RandomWalk(animals.get(i));

                    for (Animal animal : animals) {

                        if (animal.getName().equals("CHICKEN") || animal.getName().equals("TURKEY") || animal.getName().equals("BUFFALO")) {

                            if (animal.getPoint().equals(animals.get(i).getPoint())) {

                                animals.remove(animal);
                            }
                        }
                    }

                    RandomWalk(animals.get(i));
                    n_n--;

                    for (Animal animal : animals) {

                        if (animal.getName().equals("CHICKEN") || animal.getName().equals("TURKEY") || animal.getName().equals("BUFFALO")) {

                            if (animal.getPoint().equals(animals.get(i).getPoint())) {

                                animals.remove(animal);
                            }
                        }
                    }
                }
            }
        }
    }

    public void RandomWalk(Animal animal) {

        Point point = animal.getPoint();
        int max, min, random, x, y;

        if (point.getX() > 0 && point.getX() < 5 && point.getY() > 0 && point.getY() < 5) {

            max = 4;
            min = 1;
            random = (int) Math.floor(Math.random() * (max - min + 1) + min);

            switch (random) {

                case 1: // right
                    x = point.getX();
                    point.setX(++x);
                    break;

                case 2: // left
                    x = point.getX();
                    point.setX(--x);
                    break;

                case 3: // up
                    y = point.getY();
                    point.setX(++y);
                    break;

                case 4: // down
                    y = point.getY();
                    point.setX(--y);
                    break;
            }
        }

        else if (point.getX() == 0 && point.getY() > 0 && point.getY() < 5) {

            max = 3;
            min = 1;
            random = (int) Math.floor(Math.random() * (max - min + 1) + min);

            switch (random) {

                case 1: // right
                    x = point.getX();
                    point.setX(++x);
                    break;

                case 2: // left
                    x = point.getX();
                    point.setX(--x);
                    break;

                case 3: // down
                    y = point.getY();
                    point.setX(--y);
                    break;
            }
        }

        else if (point.getX() == 5 && point.getY() > 0 && point.getY() < 5) {

            max = 3;
            min = 1;
            random = (int) Math.floor(Math.random() * (max - min + 1) + min);

            switch (random) {

                case 1: // right
                    x = point.getX();
                    point.setX(++x);
                    break;

                case 2: // left
                    x = point.getX();
                    point.setX(--x);
                    break;

                case 3: // up
                    y = point.getY();
                    point.setX(++y);
                    break;
            }
        }

        else if (point.getY() == 5 && point.getX() > 0 && point.getX() < 5){

            max = 3;
            min = 1;
            random = (int) Math.floor(Math.random() * (max - min + 1) + min);

            switch (random) {

                case 1: // left
                    x = point.getX();
                    point.setX(--x);
                    break;

                case 2: // up
                    y = point.getY();
                    point.setX(++y);
                    break;

                case 3: // down
                    y = point.getY();
                    point.setX(--y);
                    break;
            }

        }

        else if (point.getY() == 0 && point.getX() > 0 && point.getX() < 5){

            max = 3;
            min = 1;
            random = (int) Math.floor(Math.random() * (max - min + 1) + min);

            switch (random) {

                case 1: // right
                    x = point.getX();
                    point.setX(++x);
                    break;

                case 2: // up
                    y = point.getY();
                    point.setX(++y);
                    break;

                case 3: // down
                    y = point.getY();
                    point.setX(--y);
                    break;
            }
        }

        else if (point.getY() == 0 && point.getX() == 0){

            max = 2;
            min = 1;
            random = (int) Math.floor(Math.random() * (max - min + 1) + min);

            switch (random) {

                case 1: // right
                    x = point.getX();
                    point.setX(++x);
                    break;

                case 2: // down
                    y = point.getY();
                    point.setX(--y);
                    break;
            }
        }

        else if (point.getY() == 0 && point.getX() == 5){

            max = 2;
            min = 1;
            random = (int) Math.floor(Math.random() * (max - min + 1) + min);

            switch (random) {

                case 1: // left
                    x = point.getX();
                    point.setX(--x);
                    break;

                case 2: // down
                    y = point.getY();
                    point.setX(--y);
                    break;
            }
        }

        else if (point.getY() == 5 && point.getX() == 0){

            max = 2;
            min = 1;
            random = (int) Math.floor(Math.random() * (max - min + 1) + min);

            switch (random) {

                case 1: // right
                    x = point.getX();
                    point.setX(++x);
                    break;

                case 2: // up
                    y = point.getY();
                    point.setX(++y);
                    break;
            }
        }

        else if (point.getY() == 5 && point.getX() == 5){

            max = 2;
            min = 1;
            random = (int) Math.floor(Math.random() * (max - min + 1) + min);

            switch (random) {

                case 1: // left
                    x = point.getX();
                    point.setX(--x);
                    break;

                case 2: // up
                    y = point.getY();
                    point.setX(++y);
                    break;
            }
        }
    }

    // update factories and their products

    public void UpdateFactoriesAndTheirProducts(int n) {

        for (int i = 0; i < factories.size(); i++) {
            if(factories.get(i).isOrder()&&this.timeIndex-factories.get(i).getTimeToOrder()>=factories.get(i).getTimeToProduce()){
                factories.get(i).setOrder(false);
                switch (factories.get(i).getOutputProduct()){
                    case "POWDER":
                        Powder powder=new Powder(timeIndex);
                        products.add(powder);
                        if(factories.get(i).getUpgradeMood()==1){
                            Powder powder1=new Powder(timeIndex);
                            products.add(powder1);
                        }
                        logger.printInfo("POWDER PLANT MADE A POWDER");
                        break;

                    case "BREAD":
                        Bread bread=new Bread(timeIndex);
                        products.add(bread);
                        if(factories.get(i).getUpgradeMood()==1){
                            Bread bread1=new Bread(timeIndex);
                            products.add(bread1);
                        }
                        logger.printInfo("BAKERY MADE A BREAD");
                        break;

                    case "PACKEDMILK":
                        PackedMilk packedMilk=new PackedMilk(timeIndex);
                        products.add(packedMilk);
                        if(factories.get(i).getUpgradeMood()==1) {
                            PackedMilk packedMilk1=new PackedMilk(timeIndex);
                            products.add(packedMilk1);
                        }
                        logger.printInfo("MILK PACKING MADE A PACKED MILK");
                        break;

                    case "DRESS":
                        Dress dress=new Dress(timeIndex);
                        products.add(dress);
                        if(factories.get(i).getUpgradeMood()==1) {
                            Dress dress1=new Dress(timeIndex);
                            products.add(dress1);
                        }
                        logger.printInfo("SEWING MADE A DRESS");
                        break;

                    case "CLOTHES":
                        Clothes clothes=new Clothes(timeIndex);
                        products.add(clothes);
                        if(factories.get(i).getUpgradeMood()==1) {
                            Clothes clothes1=new Clothes(timeIndex);
                            products.add(clothes);
                        }
                        logger.printInfo("WEAVING MADE A CLOTHE");
                        break;

                    case "ICECREAM":
                        IceCream iceCream=new IceCream(timeIndex);
                        products.add(iceCream);
                        if(factories.get(i).getUpgradeMood()==1) {
                            IceCream iceCream1=new IceCream(timeIndex);
                            products.add(iceCream1);
                        }
                        logger.printInfo("ICE CREAM FACTORY MADE AN ICE CREAM");
                        break;
                }
            }
        }
    }

    public void UpdateAnimalsAndTheirProducts1(int n){
        for (int j = n-1; j >= 0; j--) {
            for (int i = 0; i < this.animals.size(); i++) {

                //walk
                if ((animals.get(i).getName().equals("CAT") && products.isEmpty()) || (animals.get(i).getName().equals("CHICKEN") && grasses.isEmpty()) ||
                        (animals.get(i).getName().equals("TURKEY") && grasses.isEmpty()) || (animals.get(i).getName().equals("BUFFALO") && grasses.isEmpty())
                        || animals.get(i).getName().equals("BEAR") || animals.get(i).getName().equals("LION") || animals.get(i).getName().equals("TIGER") || animals.get(i).getName().equals("DOG")
                        ||(animals.get(i).getName().equals("CHICKEN")&&animals.get(i).getHealth()>=50)||(animals.get(i).getName().equals("BUFFALO")&&animals.get(i).getHealth()>=50)||(animals.get(i).getName().equals("TURKEY")&&animals.get(i).getHealth()>=50)
                ) {
                    animals.get(i).randWalk();
                } else
                    animals.get(i).walk(this.grasses, this.products);


                //check wild animals
                if (i!=animals.size()&&(animals.get(i).getName().equals("BEAR") || animals.get(i).getName().equals("LION") || animals.get(i).getName().equals("TIGER"))) {
                    for (int i1 = 0; i1 < this.animals.size(); i1++) {
                            if (i1!=animals.size()&&(animals.get(i1).getName().equals("CHICKEN") || animals.get(i1).getName().equals("TURKEY") || animals.get(i1).getName().equals("BUFFALO") || animals.get(i1).getName().equals("CAT"))) {
                                if (animals.get(i).getPoint().isEqual(animals.get(i1).getPoint())) {
                                    logger.printInfo(animals.get(i).getName()+" KILLED " + animals.get(i1).getName());
                                    animals.remove(i1);
                                    if(i1<i){
                                        --i;
                                        if(i<0)
                                            i=0;
                                    }
                                    --i1;
                                    if(i1<0)
                                        i1=0;
                                }
                            } else if (i1!=animals.size()&&animals.get(i1).getName().equals("DOG")) {
                                if (animals.get(i).getPoint().isEqual(animals.get(i1).getPoint())) {
                                    logger.printInfo(animals.get(i).getName()+" FIGHT WITH " + animals.get(i1).getName());
                                    animals.remove(i1);
                                    if(i1<i){
                                        --i;
                                        if(i<0)
                                            i=0;
                                    }
                                    animals.remove(i);
                                    --i1;
                                    --i;
                                    if(i<0)
                                        i=0;
                                    if(i1<0)
                                        i1=0;
                                }
                            }
                            if (animals.get(i).getName().equals("TIGER")) {
                                if (((Tiger) animals.get(i)).getLastPoint().isEqual(animals.get(i1).getPoint())) {
                                    if (i1!=animals.size()&&(animals.get(i1).getName().equals("CHICKEN") || animals.get(i1).getName().equals("TURKEY") || animals.get(i1).getName().equals("BUFFALO") || animals.get(i1).getName().equals("CAT"))) {
                                        logger.printInfo(animals.get(i).getName()+" KILLED " + animals.get(i1).getName());
                                        animals.remove(i1);
                                        if(i1<i){
                                            --i;
                                            if(i<0)
                                                i=0;
                                        }
                                        --i1;
                                        if(i1<0)
                                            i1=0;
                                    } else if (i1!=animals.size()&&animals.get(i1).getName().equals("DOG")) {
                                        logger.printInfo(animals.get(i).getName()+" FIGHT WITH " + animals.get(i1).getName());
                                        animals.remove(i1);
                                        if(i1<i){
                                            --i;
                                            if(i<0)
                                                i=0;
                                        }
                                        animals.remove(i);
                                        --i1;
                                        --i;
                                        if(i<0)
                                            i=0;
                                        if(i1<0)
                                            i1=0;
                                    }
                                }
                        }
                    }
                }


                //product
                if (animals.get(i).getName().equals("CHICKEN") || animals.get(i).getName().equals("TURKEY") || animals.get(i).getName().equals("BUFFALO")) {
                    if (animals.get(i).getName().equals("CHICKEN") && timeIndex - j - ((Chicken) animals.get(i)).getLastTime() == ((Chicken) animals.get(i)).getTimeForEgging()) {
                        ((Chicken) animals.get(i)).setLastTime(timeIndex - j);
                        Egg egg = new Egg(timeIndex - j);
                        egg.getPoint().setX(animals.get(i).getPoint().getX());
                        egg.getPoint().setY(animals.get(i).getPoint().getY());
                        products.add(egg);
                    } else if (animals.get(i).getName().equals("BUFFALO") && timeIndex - j - ((Buffalo) animals.get(i)).getLastTime() == ((Buffalo) animals.get(i)).getTimeForEgging()) {
                        ((Buffalo) animals.get(i)).setLastTime(timeIndex - j);
                        Milk milk = new Milk(timeIndex - j);
                        milk.getPoint().setX(animals.get(i).getPoint().getX());
                        milk.getPoint().setY(animals.get(i).getPoint().getY());
                        products.add(milk);
                    } else if (animals.get(i).getName().equals("TURKEY") && timeIndex - j - ((Turkey) animals.get(i)).getLastTime() == ((Turkey) animals.get(i)).getTimeForEgging()) {
                        ((Turkey) animals.get(i)).setLastTime(timeIndex - j);
                        Feather feather = new Feather(timeIndex - j);
                        feather.getPoint().setX(animals.get(i).getPoint().getX());
                        feather.getPoint().setY(animals.get(i).getPoint().getY());
                        products.add(feather);
                    }
                }

                //eat grasses
                if (i!=animals.size()&&animals.get(i).getHealth()<=50&&(animals.get(i).getName().equals("CHICKEN") || animals.get(i).getName().equals("TURKEY") || animals.get(i).getName().equals("BUFFALO"))) {
                    int minHealth = animals.get(i).getHealth();
                    for (int i1 = 0; i1 < grasses.size(); i1++) {
                        if (grasses.get(i1).getPoint().isEqual(animals.get(i).getPoint())) {
                            for (int i2 = 0; i2 < animals.size(); i2++) {
                                if (animals.get(i2).getName().equals("CHICKEN") || animals.get(i2).getName().equals("TURKEY") || animals.get(i2).getName().equals("BUFFALO")) {
                                    if (grasses.get(i1).getPoint().isEqual(animals.get(i2).getPoint())) {
                                        if (minHealth < animals.get(i2).getHealth()) {
                                            minHealth = animals.get(i2).getHealth();
                                        }
                                    }
                                }
                            }
                        }
                    }

                    for (int i1 = 0; i1 < animals.size(); i1++) {
                        for (int i2 = 0; i2 < grasses.size(); i2++) {
                            if (animals.get(i1).getName().equals("CHICKEN") || animals.get(i1).getName().equals("TURKEY") || animals.get(i1).getName().equals("BUFFALO")) {
                                if (animals.get(i1).getHealth() == minHealth && animals.get(i1).getPoint().isEqual(grasses.get(i2).getPoint())) {
                                    grasses.remove(i2);
                                    --i2;
                                    if(i2<0)
                                        i2=0;
                                    animals.get(i1).setHealth(100);
                                }
                            }
                        }
                    }
                }

                //cat
                if (i!=animals.size()&&animals.get(i).getName().equals("CAT")) {
                    for (int i1 = 0; i1 < this.products.size(); i1++) {
                        if (animals.get(i).getPoint().isEqual(products.get(i1).getPoint())) {
                            storeroom.getProducts().add(products.get(i1));
                            updateMission(products.get(i1));
                            products.remove(i1);
                            --i1;
                            if(i1<0)
                                i1=0;
                        }
                    }
                }

                //die
                if (animals.get(i).getName().equals("CHICKEN") || animals.get(i).getName().equals("TURKEY") || animals.get(i).getName().equals("BUFFALO")) {
                    animals.get(i).setHealth(animals.get(i).getHealth() - 10);
                    if (animals.get(i).getHealth() <= 0) {
                        logger.printInfo(animals.get(i).getName() + " DIED!");
                        animals.remove(i);
                        --i;
                        if (i < 0)
                            i = 0;
                    }
                }
            }
        }


    }

    public void inquiry(){
        System.out.println("TIME :"+timeIndex+"     COIN :"+this.user.getCoins()+"     LEVEL :"+this.level);
        screen=new int[6][6];
        for (int i = 0; i < 6; i++) {
            for (int i1 = 0; i1 < 6; i1++) {
                for (int j = 0; j < grasses.size(); j++) {
                    if(i+1 == grasses.get(j).getPoint().getX() && i1+1 == grasses.get(j).getPoint().getY()){
                        screen[i][i1]++;
                    }
                }
            }
        }

        System.out.println("GRASSES:");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(screen[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("ANIMALS AND PRODUCTS:");
        for (int i = 0; i < animals.size(); i++) {
            System.out.print(animals.get(i).getName());
            if(animals.get(i).getName().equals("TIGER")||animals.get(i).getName().equals("LION")||animals.get(i).getName().equals("BEAR")){
            System.out.print(" "+animals.get(i).getHealth()+" "+animals.get(i).getPoint().print()+"\n");
            }else if(animals.get(i).getName().equals("CAT")||animals.get(i).getName().equals("DOG")){
                System.out.print(" "+animals.get(i).getPoint().print()+"\n");
            }else
                System.out.print(" "+animals.get(i).getHealth()+"%"+animals.get(i).getPoint().print()+"\n");
        }

        for (int i = 0; i < products.size(); i++) {
            System.out.print(products.get(i).getName()+" "+products.get(i).getPoint().print());
        }
        System.out.println("\nMISSIONS:");
        Set<String> productKeys=mission.productTasks.keySet();
        Set<String >animalKeys=mission.animalTask.keySet();
        for(String productKey: productKeys){
            System.out.println(productKey+" "+mission.productTasks.get(productKey)+"/"+missions.get(level-1).productTasks.get(productKey));
        }
        for(String animalKey: animalKeys){
            System.out.println(animalKey+" "+mission.animalTask.get(animalKey)+"/"+missions.get(level-1).animalTask.get(animalKey));
        }
    }
    public int load(String name){
        if(!this.truck.isOrder()) {
            for (int i = 0; i < storeroom.getProducts().size(); i++) {
                if (storeroom.getProducts().get(i).getName().equals(name)) {
                    if (truck.getCapacity() >= storeroom.getProducts().get(i).getCapacity()) {
                        truck.updateCapacity(storeroom.getProducts().get(i));
                        storeroom.setCapacity(storeroom.getCapacity() + storeroom.getProducts().get(i).getCapacity());
                        storeroom.getProducts().remove(i);
                        logger.printInfo("YOU LOAD " + name);
                        System.out.println("YOU LOAD " + name);
                        return 1;
                    } else {
                        logger.printError("NO ENOUGH ROOM!");
                        System.out.println("NO ENOUGH ROOM!");
                        return 0;
                    }
                }
            }
            for (int i = 0; i < storeroom.getAnimals().size(); i++) {
                if (storeroom.getAnimals().get(i).getName().equals(name)) {
                    if (truck.getCapacity() >= storeroom.getAnimals().get(i).getCapacity()) {
                        truck.updateCapacity(storeroom.getAnimals().get(i));
                        if (name.equals("BEAR") || name.equals("LION") || name.equals("TIGER"))
                            storeroom.setCapacity(storeroom.getCapacity() + storeroom.getAnimals().get(i).getCapacity());
                        storeroom.getAnimals().remove(i);
                        logger.printInfo("YOU LOAD " + name);
                        System.out.println("YOU LOAD " + name);
                        return 1;
                    } else {
                        logger.printError("NO ENOUGH ROOM!");
                        System.out.println("NO ENOUGH ROOM!");
                        return 0;
                    }
                }
            }
            logger.printError("THERE ISN'T ANY " + name);
            System.out.println("THERE ISN'T ANY " + name);
            return 0;
        }else{
            logger.printError("THE TRUCK IS ON WAY");
            System.out.println("THE TRUCK IS ON WAY");
            return 0;
        }
    }
    public int unload(String name){
        if(!this.truck.isOrder()) {
            for (int i = 0; i < truck.getProducts().size(); i++) {
                if (truck.getProducts().get(i).getName().equals(name)) {
                    if (storeroom.getCapacity() >= truck.getProducts().get(i).getCapacity()) {
                        truck.setCapacity(truck.getCapacity() + truck.getProducts().get(i).getCapacity());
                        storeroom.getProducts().add(truck.getProducts().get(i));
                        storeroom.setCapacity(storeroom.getCapacity() - truck.getProducts().get(i).getCapacity());
                        truck.getProducts().remove(i);
                        --i;
                        if (i < 0)
                            i = 0;
                        logger.printInfo("YOU UNLOAD " + name);
                        System.out.println("YOU UNLOAD " + name);
                        return 1;
                    }
                }
            }
            for (int i = 0; i < truck.getAnimals().size(); i++) {
                if (truck.getAnimals().get(i).getName().equals(name)) {
                    if (storeroom.getCapacity() >= truck.getAnimals().get(i).getCapacity()) {
                        truck.setCapacity(truck.getCapacity() + truck.getAnimals().get(i).getCapacity());
                        storeroom.getAnimals().add(truck.getAnimals().get(i));
                        if (name.equals("BEAR") || name.equals("LION") || name.equals("TIGER"))
                            storeroom.setCapacity(storeroom.getCapacity() - truck.getAnimals().get(i).getCapacity());
                        truck.getAnimals().remove(i);
                        --i;
                        if (i < 0)
                            i = 0;
                        logger.printInfo("YOU UNLOAD " + name);
                        System.out.println("YOU UNLOAD " + name);
                        return 1;
                    }
                }
            }
            logger.printError("THERE ISN'T ANY " + name);
            System.out.println("THERE ISN'T ANY " + name);
            return 0;
        }else{
            logger.printError("THE TRUCK IS ON WAY");
            System.out.println("THE TRUCK IS ON WAY");
            return 0;
        }
    }
    public void truckGo(){
        if(!this.truck.isOrder()) {
            this.truck.setTimeToOrder(timeIndex);
            this.truck.setOrder(true);
            logger.printInfo("THE TRUCK IS GONE!");
            System.out.println("THE TRUCK IS GONE!");
        }else{
            logger.printError("THE TRUCK IS ON WAY");
            System.out.println("THE TRUCK IS ON WAY");
        }
    }
    public void logout(){
        logger.printInfo("LOGOUT SUCCESSFULLY!");
        saveUsers();
        this.loginStatus=1;
    }
    public void updateMission(Animal animal){
        if(mission.animalTask.containsKey(animal.getName())){
            int prim=0;
            prim=mission.animalTask.get(animal.getName());
            if(prim>0)
            mission.animalTask.put(animal.getName(),prim-1);
        }
    }
    public void updateMission(Product product){
        if(mission.productTasks.containsKey(product.getName())){
            int prim=0;
            prim=mission.productTasks.get(product.getName());
            if(prim>0)
            mission.productTasks.put(product.getName(),prim-1);
        }
    }

    public int checkStatus(){
        if(this.user.getCoins()==0&&this.storeroom.getCapacity()==30&&this.animals.isEmpty()&&this.products.isEmpty()) {
            this.gameStatus = 0;
            return 0;
        }
        boolean found=false;
        Set<String> productKeys=mission.productTasks.keySet();
        Set<String >animalKeys=mission.animalTask.keySet();
        for(String productKey: productKeys){
            if(mission.productTasks.get(productKey)!=0)
                found=true;
        }
        for(String animalKey: animalKeys){
            if(mission.animalTask.get(animalKey)!=0)
                found=true;
        }
        if (!found){
            this.gameStatus=2;
            if(this.user.getLevel()<this.level)
                this.user.setLevel(this.user.getLevel()+1);
            if(this.timeIndex<= mission.time){
                this.user.setStars(this.user.getStars()+mission.stars);
            }
            this.loginStatus=3;
            saveUsers();
        }
        return 1;
    }
    public void printStatus(){
        if(gameStatus==0) {
            System.out.println("GAME OVER!");
            logger.printInfo("GAME OVER!");
        }
        else if(gameStatus==2) {
            System.out.println("VICTORY!");
            logger.printInfo("VICTORY!");
        }
    }
    public void updateGame(){
        checkStatus();
        printStatus();
    }


    public void saveUsers(){
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        String toGson=gson.toJson(this.users);
        FileManagement fileManagement=new FileManagement();
        fileManagement.write("users.txt",toGson,false);
    }
    public void loadUsers(){
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        FileManagement fileManagement=new FileManagement();
        this.users=(ArrayList<User>) gson.fromJson(fileManagement.read("users.txt"), new TypeToken<ArrayList<User>>() {
        }.getType());
    }
    public void loadMissions(){
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        FileManagement fileManagement=new FileManagement();
        this.missions=(ArrayList<Mission>) gson.fromJson(fileManagement.read("missions.txt"), new TypeToken<ArrayList<Mission>>() {
        }.getType());
    }
}
