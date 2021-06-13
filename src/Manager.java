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


    //method
    public int login(Scanner scanner){
        System.out.println("ENTER USERNAME:");
        String username = scanner.nextLine();
        System.out.println("ENTER PASSWORD:");
        String password = scanner.nextLine();
        loadUsers();
        if(users!=null) {
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getUsername().equals(username)) {
                    if (users.get(i).getPassword().equals(password)) {
                        logger.printHeader(users.get(i));
                        logger.printInfo("LOGIN SUCCESSFULLY!!");
                        System.out.println("LOGIN SUCCESSFULLY!!");
                        this.user = users.get(i);
                        this.loginStatus = 3;
                        //todo
                        return 1;
                    }
                    else {
                        while (!users.get(i).getPassword().equals(password)) {
                            System.out.println("INCORRECT PASSWORD!!\nENTER YOUR PASSWORD AGAIN:");
                            password = scanner.nextLine();
                        }
                        logger.printHeader(users.get(i));
                        logger.printInfo("LOGIN SUCCESSFULLY!!");
                        System.out.println("LOGIN SUCCESSFULLY!!");
                        this.user = users.get(i);
                        this.loginStatus = 3;
                        //todo
                        return 1;
                    }
                }
            }
        }
        logger.printError("THERE ISN'T ANY USER WITH USER NAME "+username);
        System.out.println("THERE ISN'T ANY USER WITH USER NAME "+username);
        return 0;
    }
    public int signup(Scanner scanner){
        System.out.println("ENTER USERNAME:");
        String username = scanner.nextLine();
        System.out.println("ENTER PASSWORD:");
        String password = scanner.nextLine();
        loadUsers();
        if(users!=null) {
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getUsername().equals(username)) {
                    System.out.println("ALREADY THERE IS A USER WITH THIS USERNAME!");
                    logger.printError("ALREADY THERE IS A USER WITH THIS USERNAME!");
                    return 0;
                }
            }
        }
        else{
            users=new ArrayList<>();
        }
        System.out.println("SIGNUP SUCCESSFULLY!!");
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
    public void start(int level) throws CloneNotSupportedException {
        loadMissions();
        if(user.getLevel()>=level) {
            System.out.println("LEVEL:"+level);
            logger.printInfo("START LEVEL :"+level);
            this.mission= (Mission) missions.get(level-1).clone();
            this.user.setCoins(mission.coin);
            this.user.setLevel(mission.level);
            this.loginStatus = 0;
            this.gameStatus=1;
            this.timeIndex=0;
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
            System.out.println("PREVIOUS LEVELS AREN'T DONE!");
        }
    }
    public void buy(String name){
        if(name.equals("CHICKEN")){
            Chicken chicken=new Chicken();
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
            Turkey turkey=new Turkey();
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
            Buffalo buffalo=new Buffalo();
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
    public void pickup(int x,int y){
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getPoint().getX()==x&&products.get(i).getPoint().getY()==y){
                if(storeroom.getCapacity()>=products.get(i).getCapacity()) {
                    updateMission(products.get(i));
                    products.remove(i);
                    storeroom.getProducts().add(products.get(i));
                    storeroom.setCapacity(storeroom.getCapacity() - products.get(i).getCapacity());
                    logger.printInfo("THE PRODUCT WAS PICKED UP!");
                }
            }
        }
    }
    public void plant(int x,int y){
        if(this.waterSupplying.getCapacity()>0) {
            Grass grass = new Grass(x, y);
            this.grasses.add(grass);
            this.waterSupplying.unFill();
            System.out.println("YOU PLANT A GRASS!");
            logger.printInfo("YOU PLANT A GRASS!");
        }
    }

    public void well(){
        waterSupplying.setTimeToOrder(timeIndex,logger);
    }
    public void build(String name){
        if(name.equals("BAKERY")){
            Bakery bakery=new Bakery();
            if(this.user.getCoins()>=bakery.getPrice()){
                this.user.setCoins(this.user.getCoins()-bakery.getPrice());
                factories.add(bakery);
                System.out.println("YOU BUILD A BAKERY");
                logger.printInfo("YOU BUILD A BAKERY");
            }else{
                System.out.println("NO ENOUGH MONEY");
                logger.printError("NO ENOUGH MONEY");
            }
        }else if(name.equals("POWDERPLANT")){
            PowderPlant powderPlant=new PowderPlant();
            if(this.user.getCoins()>=powderPlant.getPrice()){
                this.user.setCoins(this.user.getCoins()-powderPlant.getPrice());
                factories.add(powderPlant);
                System.out.println("YOU BUILD A POWDERPLANT");
                logger.printInfo("YOU BUILD A POWDERPLANT");
            }else{
                System.out.println("NO ENOUGH MONEY");
                logger.printError("NO ENOUGH MONEY");
            }
        }else if(name.equals("ICECREAMFACTORY")){
            IceCreamFactory iceCreamFactory=new IceCreamFactory();
            if(this.user.getCoins()>=iceCreamFactory.getPrice()){
                this.user.setCoins(this.user.getCoins()-iceCreamFactory.getPrice());
                factories.add(iceCreamFactory);
                System.out.println("YOU BUILD A ICECREAMFACTORY");
                logger.printInfo("YOU BUILD A ICECREAMFACTORY");
            }else{
                System.out.println("NO ENOUGH MONEY");
                logger.printError("NO ENOUGH MONEY");
            }
        }else if(name.equals("WEAVING")){
            Weaving weaving=new Weaving();
            if(this.user.getCoins()>=weaving.getPrice()){
                this.user.setCoins(this.user.getCoins()-weaving.getPrice());
                factories.add(weaving);
                System.out.println("YOU BUILD A WEAVING");
                logger.printInfo("YOU BUILD A WEAVING");
            }else{
                System.out.println("NO ENOUGH MONEY");
                logger.printError("NO ENOUGH MONEY");
            }
        }else if(name.equals("SEWING")){
            Sewing sewing=new Sewing();
            if(this.user.getCoins()>=sewing.getPrice()){
                this.user.setCoins(this.user.getCoins()-sewing.getPrice());
                factories.add(sewing);
                System.out.println("YOU BUILD A SEWING");
                logger.printInfo("YOU BUILD A SEWING");
            }else{
                System.out.println("NO ENOUGH MONEY");
                logger.printError("NO ENOUGH MONEY");
            }
        }else if(name.equals("MILKPACKING")){
            MilkPacking milkPacking=new MilkPacking();
            if(this.user.getCoins()>=milkPacking.getPrice()){
                this.user.setCoins(this.user.getCoins()-milkPacking.getPrice());
                factories.add(milkPacking);
                System.out.println("YOU BUILD A MILKPACKING");
                logger.printInfo("YOU BUILD A MILKPACKING");
            }else{
                System.out.println("NO ENOUGH MONEY");
                logger.printError("NO ENOUGH MONEY");
            }
        }else{
            System.out.println("INVALID FACTORY NAME!");
            logger.printError("INVALID FACTORY NAME!");
        }
    }

    public int work(String name){
        for (int i = 0; i < factories.size(); i++) {
            if(factories.get(i).getName().equals(name)){
                for (int j = 0; j < products.size(); j++) {
                    if(products.get(j).getName().equals(factories.get(i).getInputProduct())){
                        factories.get(i).setTimeToOrder(timeIndex);
                        products.remove(j);
                        logger.printInfo("FACTORY STARTS WORKING!");
                        return 1;
                    }
                }
            }
        }
        logger.printError("INVALID FACTORY NAME OR NO INPUT PRODUCT!");
        return 0;
    }

    public void cage(int x,int y){
        for (int i = 0; i < animals.size(); i++) {
            if(animals.get(i).getName().equals("BEAR")||animals.get(i).getName().equals("LION")||animals.get(i).getName().equals("TIGER")){
                if(animals.get(i).getPoint().getX()==x&&animals.get(i).getPoint().getY()==y){
                    if(animals.get(i).getHealth()==0){
                        if(storeroom.getCapacity()>=animals.get(i).getCapacity()) {
                            storeroom.getAnimals().add(animals.get(i));
                            animals.remove(i);
                        }
                    }else
                        animals.get(i).setHealth(animals.get(i).getHealth()-1);
                }
            }
        }
    }
    public void turn(int n){

        timeIndex += n;
        UpdateUnpickedProducts(n);
        UpdateWaterSupplying(n);
        UpdateTruck(n);
        UpdateWildAnimals(n);
        UpdateAnimalsAndTheirProducts(n);
        UpdateFactoriesAndTheirProducts(n);
        inquiry();
    }


    public void UpdateUnpickedProducts(int n){
        for (int i = 0; i < products.size(); i++) {
                if(timeIndex-products.get(i).getTimeProduced()>=products.get(i).getTimeToDestroy()){
                    products.remove(i);
                }
        }
    }

    public void UpdateWildAnimals(int n){
        Set<String> wildAnimals=mission.wildAnimals.keySet();
        for(String wildAnimal: wildAnimals){
            if(mission.wildAnimals.get(wildAnimal)>=n){
                if(wildAnimal.equals("BEAR")){
                    Bear bear=new Bear();
                    this.animals.add(bear);
                    logger.printInfo("ENEMY IS ATTACKING");
                }else if(wildAnimal.equals("LION")){
                    Lion lion=new Lion();
                    this.animals.add(lion);
                    logger.printInfo("ENEMY IS ATTACKING");
                }else if(wildAnimal.equals("TIGER")){
                    Tiger tiger=new Tiger();
                    this.animals.add(tiger);
                    logger.printInfo("ENEMY IS ATTACKING");
                }
            }
        }
    }

    public void UpdateTruck(int n){
        if(this.timeIndex-this.truck.getTimeToOrder()>=this.truck.getTimeToGo()){
            for (int i = 0; i < truck.getProducts().size(); i++) {
                this.user.setCoins(this.user.getCoins()+truck.getProducts().get(i).getPrice());
            }
            for (int i = 0; i < truck.getAnimals().size(); i++) {
                this.user.setCoins(this.user.getCoins()+truck.getAnimals().get(i).getPrice());
            }
            truck.setCapacity(15);
            truck.setTimeToOrder(-1);
            truck.getProducts().clear();
            truck.getAnimals().clear();
            logger.printInfo("THE TRUCK COMES BACK");
        }
    }

    public void UpdateWaterSupplying(int n){
        if(this.timeIndex-this.waterSupplying.getTimeToOrder()>=this.waterSupplying.getTimeToFill()){
            this.waterSupplying.fill();
            logger.printInfo("THE WELL IS FILLED NOW!");
        }
    }

//     update animals and their products

    private int k_mod_timeForEgging = 0;

    public void UpdateAnimalsAndTheirProducts(int n) {

        int n_n = n;

        for (int i = 0; i < animals.size(); ++i) {

            if ("CHICKEN".equals(animals.get(i))) {

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
                        }
                    }
                }

                else animals.remove(i);
            }

            else if ("TURKEY".equals(animals.get(i))) {

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
                        }
                    }
                }

                else animals.remove(i);

            }

            else if ("BUFFALO".equals(animals.get(i))) {

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
                    } else {

                        // random walk
                        while (n_n > 0) {

                            RandomWalk(animals.get(i));
                            n_n--;
                        }
                    }
                }

                else animals.remove(i);
            }

            else if("DOG".equals(animals.get(i))){

                int health = animals.get(i).getHealth();

                if(health > 0) {

                    while(n_n > 0) {

                        RandomWalk(animals.get(i));
                        n_n--;
                    }
                }

                else animals.remove(i);
            }

            else if("CAT".equals(animals.get(i))){

                int health = animals.get(i).getHealth();

                if(health > 0) {

                    while(n_n > 0) {

                        RandomWalk(animals.get(i));
                        n_n--;
                    }
                }

                else animals.remove(i);
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
            if(this.timeIndex-factories.get(i).getTimeToOrder()>=factories.get(i).getTimeToProduce()){
                factories.get(i).setTimeToOrder(-1);
                switch (factories.get(i).getOutputProduct()){
                    case "POWDER":
                        Powder powder=new Powder(timeIndex);
                        products.add(powder);
                        logger.printInfo("POWDER PLANT MADE A POWDER");
                        break;

                    case "BREAD":
                        Bread bread=new Bread(timeIndex);
                        products.add(bread);
                        logger.printInfo("BAKERY MADE A BREAD");
                        break;

                    case "PACKEDMILK":
                        PackedMilk packedMilk=new PackedMilk(timeIndex);
                        products.add(packedMilk);
                        logger.printInfo("MILK PACKING MADE A PACKED MILK");
                        break;

                    case "DRESS":
                        Dress dress=new Dress(timeIndex);
                        products.add(dress);
                        logger.printInfo("SEWING MADE A DRESS");
                        break;

                    case "CLOTHES":
                        Clothes clothes=new Clothes(timeIndex);
                        products.add(clothes);
                        logger.printInfo("WEAVING MADE A CLOTHE");
                        break;

                    case "ICECREAM":
                        IceCream iceCream=new IceCream(timeIndex);
                        products.add(iceCream);
                        logger.printInfo("ICE CREAM FACTORY MADE AN ICE CREAM");
                        break;
                }
            }
        }
    }



    public void inquiry(){
        System.out.println("TIME :"+timeIndex);
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
            System.out.print(" "+animals.get(i).getHealth()+"% "+animals.get(i).getPoint().print()+"\n");
        }
        for (int i = 0; i < products.size(); i++) {
            System.out.print(products.get(i).getName()+" "+products.get(i).getPoint().print());
        }
        System.out.println("MISSIONS:");
        Set<String> productKeys=mission.productTasks.keySet();
        Set<String >animalKeys=mission.animalTask.keySet();
        for(String productKey: productKeys){
            System.out.println(productKey+" "+mission.productTasks.get(productKey)+"/"+missions.get(user.getLevel()-1).productTasks.get(productKey));
        }
        for(String animalKey: animalKeys){
            System.out.println(animalKey+" "+mission.animalTask.get(animalKey)+"/"+missions.get(user.getLevel()-1).animalTask.get(animalKey));
        }
    }
    public void load(String name){
        for (int i = 0; i < storeroom.getProducts().size(); i++) {
            if(storeroom.getProducts().get(i).getName().equals(name)){
                if(truck.getCapacity()>=storeroom.getProducts().get(i).getCapacity()) {
                    truck.updateCapacity(storeroom.getProducts().get(i));
                    storeroom.setCapacity(storeroom.getCapacity() + storeroom.getProducts().get(i).getCapacity());
                    storeroom.getProducts().remove(i);
                }
            }
        }
        for (int i = 0; i < storeroom.getAnimals().size(); i++) {
            if(storeroom.getAnimals().get(i).getName().equals(name)){
                if(truck.getCapacity()>=storeroom.getAnimals().get(i).getCapacity()) {
                    truck.updateCapacity(storeroom.getAnimals().get(i));
                    if(name.equals("BEAR")||name.equals("LION")||name.equals("TIGER"))
                        storeroom.setCapacity(storeroom.getCapacity() + storeroom.getAnimals().get(i).getCapacity());
                    storeroom.getAnimals().remove(i);
                }
            }
        }
    }
    public void unload(String name){
        for (int i = 0; i < truck.getProducts().size(); i++) {
            if(truck.getProducts().get(i).getName().equals(name)){
                if(storeroom.getCapacity()>=truck.getProducts().get(i).getCapacity()) {
                    truck.getProducts().remove(i);
                    truck.setCapacity(truck.getCapacity() + truck.getProducts().get(i).getCapacity());
                    storeroom.getProducts().add(truck.getProducts().get(i));
                    storeroom.setCapacity(storeroom.getCapacity() - truck.getProducts().get(i).getCapacity());
                }
            }
        }
        for (int i = 0; i < truck.getAnimals().size(); i++) {
            if(truck.getAnimals().get(i).getName().equals(name)){
                if(storeroom.getCapacity()>=truck.getAnimals().get(i).getCapacity()){
                    truck.getAnimals().remove(i);
                    truck.setCapacity(truck.getCapacity() + truck.getAnimals().get(i).getCapacity());
                    storeroom.getAnimals().add(truck.getAnimals().get(i));
                    if(name.equals("BEAR")||name.equals("LION")|| name.equals("TIGER"))
                        storeroom.setCapacity(storeroom.getCapacity() - truck.getAnimals().get(i).getCapacity());
                }
            }
        }
    }
    public void truckGo(){
        this.truck.setTimeToOrder(timeIndex);
    }
    public void logout(){
        System.out.println("LOGOUT SUCCESSFULLY!");
        logger.printInfo("LOGOUT SUCCESSFULLY!");
        saveUsers();
        this.loginStatus=1;
    }
    public void updateMission(Animal animal){
        if(mission.animalTask.containsKey(animal.getName())){
            int prim=0;
            prim=mission.animalTask.get(animal.getName());
            mission.animalTask.put(animal.getName(),prim-1);
        }
    }
    public void updateMission(Product product){
        if(mission.productTasks.containsKey(product.getName())){
            int prim=0;
            prim=mission.productTasks.get(product.getName());
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
