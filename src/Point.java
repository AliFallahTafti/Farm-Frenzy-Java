import java.util.Random;

public class Point {
    private int x;
    private int y;

    public Point(){
        Random random=new Random();
        this.x=random.nextInt(6)+1;
        this.x=random.nextInt(6)+1;
    }
    public String  print(){
        return "["+x+" "+y+"]";
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
