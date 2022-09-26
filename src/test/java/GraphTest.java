import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class GraphTest {

    MazeGrid mazeGrid;
    Coordinate coordinate1;
    Coordinate coordinate2;
    Coordinate coordinate3;
    Coordinate coordinate4;
    Coordinate coordinate5;
    Coordinate coordinate6;
    Coordinate coordinate7;
    Coordinate coordinate8;
    Coordinate coordinate9;

    ArrayList<Coordinate> listOfCoordinates;
    ArrayList<Node> nodeArrayList;

    Graph graph;

    @Before
    public void SetUp(){
        coordinate1 = new Coordinate(0,2,CoordType.START);
        coordinate2 = new Coordinate(1,2, CoordType.WALL);
        coordinate3 = new Coordinate(2,2, CoordType.END);
        coordinate4 = new Coordinate(0,1, CoordType.PATH);
        coordinate5 = new Coordinate(1,1, CoordType.WALL);
        coordinate6 = new Coordinate(2,1, CoordType.PATH);
        coordinate7 = new Coordinate(0,0, CoordType.PATH);
        coordinate8 = new Coordinate(1,0, CoordType.PATH);
        coordinate9 = new Coordinate(2,0, CoordType.PATH);

        listOfCoordinates = new ArrayList<>();
        listOfCoordinates.add(coordinate1);
        listOfCoordinates.add(coordinate2);
        listOfCoordinates.add(coordinate3);
        listOfCoordinates.add(coordinate4);
        listOfCoordinates.add(coordinate5);
        listOfCoordinates.add(coordinate6);
        listOfCoordinates.add(coordinate7);
        listOfCoordinates.add(coordinate8);
        listOfCoordinates.add(coordinate9);


        mazeGrid = new MazeGrid(3,3, listOfCoordinates);
        nodeArrayList = new ArrayList<>(mazeGrid.getNodeList());
        graph = new Graph(nodeArrayList);

    }

    @Test
    public void canGetNodeX(){
        assertEquals(0,nodeArrayList.get(0).getX());
    }

    @Test
    public void canGetNodeY(){
        assertEquals(2, nodeArrayList.get(0).getY());
    }

    @Test
    public void canGetNodeID(){
        assertEquals(0, nodeArrayList.get(0).getId());
    }

    @Test
    public void getSizeOfAdjacencyList(){
        assertEquals(0, graph.getAdjacencyListSize());
    }

    @Test
    public void getSizeOfNodeList(){
        assertEquals(7, graph.getNodeArrayListSize());
    }

    @Test
    public void canPrint(){
        graph.addNodes();
        graph.findEdges();
        graph.print();
    }
}
