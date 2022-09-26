public class Coordinate {

    private int x;
    private int y;
    protected CoordType coordType;

    public Coordinate(){

    }
    public Coordinate(int x, int y, CoordType coordType){
        this.x = x;
        this.y = y;
        this.coordType = coordType;
    }



    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }


}
