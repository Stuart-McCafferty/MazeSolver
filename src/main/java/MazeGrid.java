import java.util.ArrayList;
import java.util.List;

//Going to give mazegrid a list of Coordinate objects to store into a 2d array
public class MazeGrid {


    private final int height;
    private final int width;
    private ArrayList<Coordinate> listOfCoordinates;
    private Coordinate[][] coordinates;
    private Coordinate startPoint;
    private Coordinate endPoint;
    private int noOfPaths;


    public MazeGrid(int height, int width, ArrayList<Coordinate> listOfCoordinates){
        this.height = height;
        this.width = width;
        this.listOfCoordinates = listOfCoordinates;
        coordinates = new Coordinate[height][width];
//        startPoint = new Coordinate();
//        endPoint = new Coordinate();
        this.noOfPaths = 0;

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

    public Coordinate[][] getCoordinates() {
        return this.coordinates;
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
//        Coordinate tempCoords[] = new Coordinate[this.getWidth()];
//        for (int i = 1; i < this.getHeight(); i++) {
//            tempCoords = listOfCoordinates.subList(0, this.getWidth()).toArray(new Coordinate[0]);
//        }
        //Loop for height
            //tempArray = Split from index 0 to width-1
            //add new array to coordinates array(produces 2d array)
        
    }

    //Need to give it a list of coordinates to loop through the list to find the Start point
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

    public int getCoordinatesRowSize(int i) {

    }
}
