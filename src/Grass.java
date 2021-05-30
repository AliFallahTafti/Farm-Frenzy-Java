public class Grass {
    private Point point;

    public Grass(int x,int y){
        point=new Point();
        point.setX(x);
        point.setY(y);
    }

    public Point getPoint() {
        return point;
    }
}
