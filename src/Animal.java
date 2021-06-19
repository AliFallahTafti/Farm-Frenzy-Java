import java.util.ArrayList;
import java.util.Random;

public class Animal {

    private Point point;
    private String name;
    private int capacity;
    private int price;
    private int health;

    public Animal(String name,int capacity){

        this.point = new Point();
        this.name = name;
        this.capacity = capacity;
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


    //method
    public void walk(ArrayList<Grass>grasses,ArrayList<Product>products){
        if(this.name.equals("CHICKEN")||this.name.equals("TURKEY")||this.name.equals("BUFFALO")){
            double min=10;
            Grass grass=new Grass(1,1);
            for (int i = 0; i < grasses.size(); i++) {
                if(this.point.distance(grasses.get(i).getPoint())<min){
                    min=this.point.distance(grasses.get(i).getPoint());
                    grass.getPoint().setX(grasses.get(i).getPoint().getX());
                    grass.getPoint().setY(grasses.get(i).getPoint().getY());
                }
            }
            boolean found=false;
            if(this.point.getX()<grass.getPoint().getX()){
                this.point.setX(this.point.getX()+1);
                found=true;
            }else if(!found&&this.point.getX()>grass.getPoint().getX()){
                this.point.setX(this.point.getX()-1);
                found=true;
            }else if(!found&&this.point.getY()<grass.getPoint().getY()){
                this.point.setY(this.point.getY()+1);
                found=true;
            }else if(!found&&this.point.getY()>grass.getPoint().getY()){
                this.point.setY(this.point.getY()-1);
            }
        }else if(this.name.equals("CAT")){
            double min=10;
            Grass grass=new Grass(1,1);
            for (int i = 0; i < products.size(); i++) {
                if(this.point.distance(products.get(i).getPoint())<min){
                    min=this.point.distance(products.get(i).getPoint());
                    grass.getPoint().setX(products.get(i).getPoint().getX());
                    grass.getPoint().setY(products.get(i).getPoint().getY());
                }
            }
            boolean found=false;
            if(this.point.getX()<grass.getPoint().getX()){
                this.point.setX(this.point.getX()+1);
                found=true;
            }else if(!found&&this.point.getX()>grass.getPoint().getX()){
                this.point.setX(this.point.getX()-1);
                found=true;
            }else if(!found&&this.point.getY()<grass.getPoint().getY()){
                this.point.setY(this.point.getY()+1);
                found=true;
            }else if(!found&&this.point.getY()>grass.getPoint().getY()){
                this.point.setY(this.point.getY()-1);
            }
        }
    }

    public void randWalk() {
        boolean found = false;
        if (!this.name.equals("TIGER")) {
            while (!found) {
                Random random = new Random();
                int dir = random.nextInt();
                if (dir % 4 == 0) {
                    if (this.point.getX() < 6) {
                        this.point.setX(this.point.getX() + 1);
                        found = true;
                    }
                } else if (dir % 4 == 1) {
                    if (this.point.getX() > 1) {
                        this.point.setX(this.point.getX() - 1);
                        found = true;
                    }
                } else if (dir % 4 == 2) {
                    if (this.point.getY() < 6) {
                        this.point.setY(this.point.getY() + 1);
                        found = true;
                    }
                } else if (dir % 4 == 3) {
                    if (this.point.getY() > 1) {
                        this.point.setY(this.point.getY() - 1);
                        found = true;
                    }
                }
            }
        } else {

            while (!found && this.name.equals("TIGER")) {
                Random random = new Random();
                int dir = random.nextInt();
                if (dir % 4 == 0) {
                    if (this.point.getX() < 5) {
                        this.point.setX(this.point.getX() + 2);
                        ((Tiger)this).getLastPoint().setX(this.point.getX()-1);
                        ((Tiger)this).getLastPoint().setY(this.point.getY());
                        found = true;
                    }
                } else if (dir % 4 == 1) {
                    if (this.point.getX() > 2) {
                        this.point.setX(this.point.getX() - 2);
                        ((Tiger)this).getLastPoint().setX(this.point.getX()+1);
                        ((Tiger)this).getLastPoint().setY(this.point.getY());
                        found = true;
                    }
                } else if (dir % 4 == 2) {
                    if (this.point.getY() < 5) {
                        this.point.setY(this.point.getY() + 2);
                        ((Tiger)this).getLastPoint().setX(this.point.getX());
                        ((Tiger)this).getLastPoint().setY(this.point.getY()-1);
                        found = true;
                    }
                } else if (dir % 4 == 3) {
                    if (this.point.getY() > 2) {
                        this.point.setY(this.point.getY() - 2);
                        ((Tiger)this).getLastPoint().setX(this.point.getX());
                        ((Tiger)this).getLastPoint().setY(this.point.getY()+1);
                        found = true;
                    }
                }
            }
        }
    }
}
