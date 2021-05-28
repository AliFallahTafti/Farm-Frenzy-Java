import jdk.nashorn.internal.runtime.JSONFunctions;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
    private User user;
    private Mission mission;
    private Storeroom storeroom;
    private WaterSupplying waterSupplying;
    private Truck truck;
    private ArrayList<User>users;
    private ArrayList<Animal>animals;
    private ArrayList<Grass>grasses;
    private ArrayList<Product>products;
    private ArrayList<Mission>missions;
    private int timeIndex;
    private int loginStatus;  //0login    1logout     2exit      3menu


    public Manager(){
        this.users=new ArrayList<>();
        this.animals=new ArrayList<>();
        this.missions=new ArrayList<>();
        this.grasses=new ArrayList<>();
        this.storeroom=new Storeroom();
        this.products=new ArrayList<>();
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
                        System.out.println("LOGIN SUCCESSFULLY!!");
                        this.user = users.get(i);
                        this.loginStatus = 3;
                        //todo
                        return 1;
                    } else {
                        while (!users.get(i).getPassword().equals(password)) {
                            System.out.println("INCORRECT PASSWORD!!\nENTER YOUR PASSWORD AGAIN:");
                            password = scanner.nextLine();
                        }
                        System.out.println("LOGIN SUCCESSFULLY!!");
                        this.user = users.get(i);
                        this.loginStatus = 3;
                        //todo
                        return 1;
                    }
                }
            }
        }
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
            users.add(user1);
            this.user = user1;
            //todo
            return 1;
    }
    public void exit(){
        this.loginStatus=2;
        saveUsers();
    }
    public void start(int level){
        loadMissions();
        this.loginStatus=0;
    }
    public void buy(String name){
        if(name.equals("CHICKEN")){
            Chicken chicken=new Chicken();
            if(this.user.getCoins()>=chicken.getPrice()) {
                animals.add(chicken);
                storeroom.getAnimals().add(chicken);
            }
        }else if(name.equals("TURKEY")){
            Turkey turkey=new Turkey();
            if(this.user.getCoins()>=turkey.getPrice()) {
                animals.add(turkey);
                storeroom.getAnimals().add(turkey);
            }
        }else if(name.equals("BUFFALO")){
            Buffalo buffalo=new Buffalo();
            if(this.user.getCoins()>=buffalo.getPrice()) {
                animals.add(buffalo);
                storeroom.getAnimals().add(buffalo);
            }
        }else if(name.equals("DOG")){
            Cat cat=new Cat();
            if(this.user.getCoins()>=cat.getPrice()) {
                animals.add(cat);
                storeroom.getAnimals().add(cat);
            }
        }else if(name.equals("CAT")){
            Dog dog=new Dog();
            if(this.user.getCoins()>=dog.getPrice()) {
                animals.add(dog);
                storeroom.getAnimals().add(dog);
            }
        }else
            System.out.println("THERE ISN'T ANY ANIMAL WITH NAME :"+name);
    }
    public void pickup(int x,int y){
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).point.getX()==x&&products.get(i).point.getY()==y){
                if(storeroom.getCapacity()<=storeroom.getMaxCapacity()-products.get(i).getCapacity()) {
                    storeroom.getProducts().add(products.get(i));
                    storeroom.setCapacity(storeroom.getCapacity() + products.get(i).getCapacity());
                }
            }
        }
    }
    public void plant(int x,int y){
        Grass grass=new Grass(x,y);
        this.grasses.add(grass);
    }
    public void well(){
        waterSupplying.fill();
    }
    public void work(String name){

    }
    public void cage(int x,int y){
        for (int i = 0; i < animals.size(); i++) {

        }
    }
    public void turn(int n){
        for (int i = 0; i < n; i++) {
            updateGame();
        }
    }
    public void load(String name){
        for (int i = 0; i < storeroom.getProducts().size(); i++) {
            if(products.get(i).getName().equals(name)){
                truck.updateCapacity(products.get(i));
                storeroom.setCapacity(storeroom.getCapacity()-products.get(i).getCapacity());
                storeroom.getProducts().remove(products.get(i));
            }
        }
        for (int i = 0; i < storeroom.getAnimals().size(); i++) {
            if(animals.get(i).getName().equals(name)){
                truck.updateCapacity(animals.get(i));
                storeroom.setCapacity(storeroom.getCapacity()-products.get(i).getCapacity());
                storeroom.getAnimals().remove(animals.get(i));
            }
        }
    }
    public void unload(String name){

    }
    public void truckGo(){

    }
    public void logout(){
        this.loginStatus=1;
    }
    public void updateGame(){
        ++this.timeIndex;
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
