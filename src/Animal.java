import java.util.ArrayList;
import java.util.Random;

public class Animal {

    private Point point;
    private String name;
    private int capacity;
    private int price;
    private int health;
    private int stateOfWalk; //0 up   1 right   2 left   3down


    public Animal(String name,int capacity){

        this.point = new Point();
        this.name = name;
        this.capacity = capacity;
        Random random=new Random();
        this.stateOfWalk=random.nextInt(4);
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public int getStateOfWalk() {
        return stateOfWalk;
    }

    public boolean isFull(){
        return false;
    }
    //method
    public void walk(ArrayList<Grass>grasses,ArrayList<Product>products){
        int amount=10;
        if(this.name.equals("CHICKEN")||this.name.equals("TURKEY")||this.name.equals("BUFFALO")){
            double min=10000;
            Grass grass=new Grass(1,1);
            for (int i = 0; i < grasses.size(); i++) {
                if(this.point.distance(grasses.get(i).getPoint())<min){
                    min=this.point.distance(grasses.get(i).getPoint());
                    grass.getPoint().setX(grasses.get(i).getPoint().getX());
                    grass.getPoint().setY(grasses.get(i).getPoint().getY());
                }
            }
            boolean found=false;
            if(this.point.getX()+amount<grass.getPoint().getX()||this.point.getX()-amount>grass.getPoint().getX()){
            if(this.point.getX()<=grass.getPoint().getX()+amount){
                this.point.setX(this.point.getX()+amount);
                found=true;
                this.stateOfWalk=1;
            }else if(!found&&this.point.getX()>=grass.getPoint().getX()-amount){
                this.point.setX(this.point.getX()-amount);
                found=true;
                this.stateOfWalk=2;
            }}else if(!found&&this.point.getY()<=grass.getPoint().getY()+amount){
                this.point.setY(this.point.getY()+amount);
                found=true;
                this.stateOfWalk=3;
            }else if(!found&&this.point.getY()>=grass.getPoint().getY()-amount){
                this.point.setY(this.point.getY()-amount);
                this.stateOfWalk=0;
            }
        }else if(this.name.equals("CAT")){
            double min=10000;
            Grass grass=new Grass(1,1);
            for (int i = 0; i < products.size(); i++) {
                if(this.point.distance(products.get(i).getPoint())<min){
                    min=this.point.distance(products.get(i).getPoint());
                    grass.getPoint().setX(products.get(i).getPoint().getX());
                    grass.getPoint().setY(products.get(i).getPoint().getY());
                }
            }
            boolean found=false;
            if(this.point.getX()+amount<grass.getPoint().getX()||this.point.getX()-amount>grass.getPoint().getX()){
                if(this.point.getX()<=grass.getPoint().getX()+amount){
                this.point.setX(this.point.getX()+amount);
                found=true;
                this.stateOfWalk=1;
            }else if(!found&&this.point.getX()>=grass.getPoint().getX()-amount){
                this.point.setX(this.point.getX()-amount);
                found=true;
                this.stateOfWalk=2;
            }}else if(!found&&this.point.getY()<=grass.getPoint().getY()+amount){
                this.point.setY(this.point.getY()+amount);
                found=true;
                this.stateOfWalk=3;
            }else if(!found&&this.point.getY()>=grass.getPoint().getY()-amount){
                this.point.setY(this.point.getY()-amount);
                this.stateOfWalk=0;
            }
        }
    }

    public void randWalk() {
        int amount=10;
        boolean found = false;
        if (!this.name.equals("TIGER")) {
            while (!found) {
                Random random = new Random();
                int dir = random.nextInt();
                if (dir % 4 == 0) {
                    if (this.point.getX() <= point.getMaxX()-amount) {
                        this.point.setX(this.point.getX() + amount);
                        found = true;
                        this.stateOfWalk=1;
                    }
                } else if (dir % 4 == 1) {
                    if (this.point.getX() >= point.getMinX()+amount) {
                        this.point.setX(this.point.getX() - amount);
                        found = true;
                        this.stateOfWalk=2;
                    }
                } else if (dir % 4 == 2) {
                    if (this.point.getY() <= point.getMaxY()-amount) {
                        this.point.setY(this.point.getY() + amount);
                        found = true;
                        this.stateOfWalk=3;
                    }
                } else if (dir % 4 == 3) {
                    if (this.point.getY() >= point.getMinY()+amount) {
                        this.point.setY(this.point.getY() - amount);
                        found = true;
                        this.stateOfWalk=0;
                    }
                }
            }
        } else {

            while (!found && this.name.equals("TIGER")) {
                Random random = new Random();
                int dir = random.nextInt();
                if (dir % 4 == 0) {
                    if (this.point.getX() <= point.getMaxX()-2*amount) {
                        this.point.setX(this.point.getX() + 2*amount);
                        ((Tiger)this).getLastPoint().setX(this.point.getX()-amount);
                        ((Tiger)this).getLastPoint().setY(this.point.getY());
                        found = true;
                        this.stateOfWalk=1;
                    }
                } else if (dir % 4 == 1) {
                    if (this.point.getX() >= point.getMinX()+2*amount) {
                        this.point.setX(this.point.getX() - 2*amount);
                        ((Tiger)this).getLastPoint().setX(this.point.getX()+amount);
                        ((Tiger)this).getLastPoint().setY(this.point.getY());
                        found = true;
                        this.stateOfWalk=2;
                    }
                } else if (dir % 4 == 2) {
                    if (this.point.getY() <= point.getMaxY()-2*amount) {
                        this.point.setY(this.point.getY() + 2*amount);
                        ((Tiger)this).getLastPoint().setX(this.point.getX());
                        ((Tiger)this).getLastPoint().setY(this.point.getY()-amount);
                        found = true;
                        this.stateOfWalk=3;
                    }
                } else if (dir % 4 == 3) {
                    if (this.point.getY() >= point.getMinY()+2*amount) {
                        this.point.setY(this.point.getY() - 2*amount);
                        ((Tiger)this).getLastPoint().setX(this.point.getX());
                        ((Tiger)this).getLastPoint().setY(this.point.getY()+amount);
                        found = true;
                        this.stateOfWalk=0;
                    }
                }
            }
        }
    }
}
