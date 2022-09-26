import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Maze {

    private Coordinate start;
    private Coordinate end;
    private Coordinate[][] grid;
    private List<Coordinate> visitedNodes;
    private Stack<Coordinate> path;

    public Maze(Coordinate start, Coordinate end, Coordinate[][] grid){
        this.start = start;
        this.end = end;
        this.grid = grid;
        visitedNodes = new ArrayList<>();
        path = new Stack<>();
    }






}
