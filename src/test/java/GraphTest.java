import com.codeclan.examples.models.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
    Coordinate coordinate10;
    Coordinate coordinate11;
    Coordinate coordinate12;
    Coordinate coordinate13;
    Coordinate coordinate14;
    Coordinate coordinate15;
    Coordinate coordinate16;
    Coordinate coordinate17;
    Coordinate coordinate18;
    Coordinate coordinate19;
    Coordinate coordinate20;
    Coordinate coordinate21;
    Coordinate coordinate22;
    Coordinate coordinate23;
    Coordinate coordinate24;
    Coordinate coordinate25;

    Node startNode;
    Node endNode;

    List<Coordinate> listOfCoordinates;
    List<Node> nodeArrayList;


    Graph graph;

    @Before
    public void SetUp(){
        //3x3 MAZE
//        coordinate1 = new com.codeclan.examples.models.Coordinate(0,2,com.codeclan.examples.models.CoordType.START);
//        coordinate2 = new com.codeclan.examples.models.Coordinate(1,2, com.codeclan.examples.models.CoordType.WALL);
//        coordinate3 = new com.codeclan.examples.models.Coordinate(2,2, com.codeclan.examples.models.CoordType.END);
//        coordinate4 = new com.codeclan.examples.models.Coordinate(0,1, com.codeclan.examples.models.CoordType.PATH);
//        coordinate5 = new com.codeclan.examples.models.Coordinate(1,1, com.codeclan.examples.models.CoordType.WALL);
//        coordinate6 = new com.codeclan.examples.models.Coordinate(2,1, com.codeclan.examples.models.CoordType.PATH);
//        coordinate7 = new com.codeclan.examples.models.Coordinate(0,0, com.codeclan.examples.models.CoordType.PATH);
//        coordinate8 = new com.codeclan.examples.models.Coordinate(1,0, com.codeclan.examples.models.CoordType.PATH);
//        coordinate9 = new com.codeclan.examples.models.Coordinate(2,0, com.codeclan.examples.models.CoordType.PATH);
//        listOfCoordinates = new ArrayList<>();
//        listOfCoordinates.add(coordinate1);
//        listOfCoordinates.add(coordinate2);
//        listOfCoordinates.add(coordinate3);
//        listOfCoordinates.add(coordinate4);
//        listOfCoordinates.add(coordinate5);
//        listOfCoordinates.add(coordinate6);
//        listOfCoordinates.add(coordinate7);
//        listOfCoordinates.add(coordinate8);
//        listOfCoordinates.add(coordinate9);
//        mazeGrid = new com.codeclan.examples.models.MazeGrid(3,3, listOfCoordinates);

        //5x5 maze

        coordinate1 = new Coordinate(0,4,CoordType.START);
        coordinate2 = new Coordinate(1,4,CoordType.PATH);
        coordinate3 = new Coordinate(2,4,CoordType.PATH);
        coordinate4 = new Coordinate(3,4,CoordType.WALL);
        coordinate5 = new Coordinate(4,4,CoordType.END);
        coordinate6 = new Coordinate(0,3,CoordType.PATH);
        coordinate7 = new Coordinate(1,3,CoordType.WALL);
        coordinate8 = new Coordinate(2,3,CoordType.PATH);
        coordinate9 = new Coordinate(3,3,CoordType.WALL);
        coordinate10 = new Coordinate(4,3,CoordType.PATH);
        coordinate11 = new Coordinate(0,2,CoordType.PATH);
        coordinate12 = new Coordinate(1,2, CoordType.WALL);
        coordinate13 = new Coordinate(2,2,CoordType.PATH);
        coordinate14 = new Coordinate(3,2,CoordType.WALL);
        coordinate15 = new Coordinate(4,2,CoordType.PATH);
        coordinate16 = new Coordinate(0,1,CoordType.PATH);
        coordinate17 = new Coordinate(1,1,CoordType.WALL);
        coordinate18 = new Coordinate(2,1,CoordType.PATH);
        coordinate19 = new Coordinate(3,1,CoordType.PATH);
        coordinate20 = new Coordinate(4,1,CoordType.PATH);
        coordinate21 = new Coordinate(0,0,CoordType.PATH);
        coordinate22 = new Coordinate(1,0,CoordType.WALL);
        coordinate23 = new Coordinate(2,0,CoordType.PATH);
        coordinate24 = new Coordinate(3,0,CoordType.PATH);
        coordinate25 = new Coordinate(4,0,CoordType.PATH);
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
        listOfCoordinates.add(coordinate10);
        listOfCoordinates.add(coordinate11);
        listOfCoordinates.add(coordinate12);
        listOfCoordinates.add(coordinate13);
        listOfCoordinates.add(coordinate14);
        listOfCoordinates.add(coordinate15);
        listOfCoordinates.add(coordinate16);
        listOfCoordinates.add(coordinate17);
        listOfCoordinates.add(coordinate18);
        listOfCoordinates.add(coordinate19);
        listOfCoordinates.add(coordinate20);
        listOfCoordinates.add(coordinate21);
        listOfCoordinates.add(coordinate22);
        listOfCoordinates.add(coordinate23);
        listOfCoordinates.add(coordinate24);
        listOfCoordinates.add(coordinate25);
        mazeGrid = new MazeGrid(5,5, listOfCoordinates);

        nodeArrayList = new ArrayList<>(mazeGrid.getNodeList());
        startNode = mazeGrid.getStartNode();
        endNode = mazeGrid.getEndNode();
//        endNode =  new Node(0,0, 0);
        graph = new Graph(nodeArrayList, startNode, endNode);

    }

    @Test
    public void canGetNodeX(){
        assertEquals(0,nodeArrayList.get(0).getX());
    }

    @Test
    public void canGetNodeY(){
        assertEquals(4, nodeArrayList.get(0).getY());
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
        assertEquals(18, graph.getNodeArrayListSize());
    }

    @Test
    public void canPrint(){
        graph.addNodes();
        graph.findEdges();
        graph.print();
    }

    @Test
    public void DFSSolve(){
        graph.addNodes();
        graph.findEdges();
        graph.DFS(startNode);
        graph.resetNodesVisited();
    }



}
