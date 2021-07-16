public class Grass {

    private Point point;
    private int numOfNeighbor;

    public Grass(int x,int y){

        point=new Point();
        point.setX(x);
        point.setY(y);
    }

    public Point getPoint() {

        return point;
    }

    public int getNumOfNeighbor() {
        return numOfNeighbor;
    }

    public void setNumOfNeighbor(int numOfNeighbor) {
        this.numOfNeighbor = numOfNeighbor;
    }
}
