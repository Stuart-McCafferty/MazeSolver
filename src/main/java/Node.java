public class Node {

    private int x;
    private int y;
    protected CoordType coordType;

    private int id;


    public Node(int x, int y, CoordType coordType, int id){
        this.x = x;
        this.y = y;
        this.coordType = coordType;
        this.id = id;
    }

}
