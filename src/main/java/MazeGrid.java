import java.util.ArrayList;
import java.util.List;

//Going to give mazegrid a list of Coordinate objects to store into a 2d array
public class MazeGrid {


    private final int height;
    private final int width;
    private ArrayList<Coordinate> listOfCoordinates;
    private ArrayList<ArrayList<Coordinate>> grid;
    private Coordinate startPoint;
    private Coordinate endPoint;
    private int noOfPaths;
    private ArrayList<Node> nodeList;


    public MazeGrid(int height, int width, ArrayList<Coordinate> listOfCoordinates){
        this.height = height;
        this.width = width;
        this.listOfCoordinates = listOfCoordinates;
        grid =  new ArrayList<ArrayList<Coordinate>>();
        startPoint = new Coordinate();
        endPoint = new Coordinate();
        this.noOfPaths = 0;
        nodeList = new ArrayList<Node>();

    }

    public int getListOfCoordinatesCount() {
        return this.listOfCoordinates.size();
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public List<ArrayList<Coordinate>> getCoordinates() {
        return this.grid;
    }

    public Coordinate getStartPoint() {
        return this.startPoint;
    }

    public Coordinate getEndPoint() {
        return this.endPoint;
    }

    public int getNoOfPaths() {
        return this.noOfPaths;
    }

    public void setCoordinates() {
        int counter  = 0;
        for (int i = 0; i < this.getHeight(); i++) {
            ArrayList<Coordinate> tempCoords = new ArrayList<Coordinate>(listOfCoordinates.subList(counter,counter+this.getWidth()));
            grid.add(tempCoords);
            System.out.println(grid);
            counter += this.getWidth();
        }
    }

    //Need to give it a list of grid to loop through the list to find the Start point
    public void setStartPoint(ArrayList<Coordinate> listOfCoordinates) {
        for (Coordinate listOfCoordinate : listOfCoordinates) {
            if ("START".equals(listOfCoordinate.coordType.getCoordinateType())) {
                this.startPoint = listOfCoordinate;
            }
        }
    }



    //    Same as above but end point
    public void setEndPoint(ArrayList<Coordinate> listOfCoordinates) {
        for (Coordinate listOfCoordinate : listOfCoordinates) {
            if ("END".equals(listOfCoordinate.coordType.getCoordinateType())) {
                this.endPoint = listOfCoordinate;
            }
        }
    }

    //    Need to loop through and count how many path blocks they are for when I build the graph
    public void setNoOfPaths(ArrayList<Coordinate> listOfCoordinates) {
        int count = 0;
        for (Coordinate listOfCoordinate : listOfCoordinates) {
            if (!"WALL".equals(listOfCoordinate.coordType.getCoordinateType())) {
                count += 1;
            }
        }
        this.noOfPaths = count;
    }

    public void printGrid(){
        for(int i = 0; i < this.getHeight(); i++){
            System.out.println();
            for(int j = 0; j < this.getWidth(); j++){
                System.out.print((grid.get(i).get(j)).coordType + " ");
            }
        }
    }
    
    public ArrayList<Node> getNodeList(){
        int counter = 0;
        for (Coordinate listOfCoordinate : listOfCoordinates) {
            if (!"WALL".equals(listOfCoordinate.coordType.getCoordinateType())) {
                Node nodeTemp = new Node(counter, listOfCoordinate.getX(), listOfCoordinate.getY());
                nodeList.add(nodeTemp);
                counter += 1;
            }
        }
        return nodeList;
    }

    public Node getStartNode(){
        for (Coordinate listOfCoordinate : listOfCoordinates) {
            if ("START".equals(listOfCoordinate.coordType.getCoordinateType())) {
                return new Node(0, listOfCoordinate.getX(), listOfCoordinate.getY());
            }
        }
        return null;
    }

    public Node getEndNode(){
        for (Coordinate listOfCoordinate : listOfCoordinates) {
            if ("END".equals(listOfCoordinate.coordType.getCoordinateType())) {
                return new Node(0, listOfCoordinate.getX(), listOfCoordinate.getY());
            }
        }
        return null;
    }
}
