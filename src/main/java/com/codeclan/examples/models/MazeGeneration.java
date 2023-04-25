package com.codeclan.examples.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.*;


public class MazeGeneration {

    private final int height;
    private final int width;
    private final GeneratorNode[][] grid;
    private GeneratorNode nextNode;
    private Boolean isFound;
    private Boolean neighbourVisited;
    private GeneratorNode nextNeighbour;
    private Stack<GeneratorNode> visitedCells;
    private List<Coordinate> listOfCoordinates;



    public MazeGeneration(int height, int width){
        this.height = height;
        this.width = width;
        this.grid = new GeneratorNode[height][width];
        isFound = Boolean.FALSE;
        nextNode = new GeneratorNode();
        nextNeighbour = new GeneratorNode();
        neighbourVisited = Boolean.FALSE;
        visitedCells = new Stack<>();
        listOfCoordinates = new ArrayList<Coordinate>();
    }

    public List<Coordinate> GenerateMaze(){
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                this.grid[i][j] = new GeneratorNode(i,j,false);
            }
        }
        this.grid[0][0] = new GeneratorNode(0,0, true);
        this.grid[height - 1][width - 1] = new GeneratorNode(height - 1, width -1, true);
        Random random = new Random();
        int randomInt = random.nextInt(height);
        int randomInt2 = random.nextInt(width);
        GenerateHelper(grid[0][0]);
        CreateListCoords();
        return listOfCoordinates;
    }

    public void CreateListCoords(){
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                Coordinate coordinateTemp;
                if(grid[y][x].isPath()){
                    coordinateTemp = new Coordinate(0, 0, CoordType.PATH);
                    listOfCoordinates.add(coordinateTemp);
                } else {
                    coordinateTemp = new Coordinate(0, 0, CoordType.WALL);
                    listOfCoordinates.add(coordinateTemp);
                }
            }
        }
        int counter = 0;
        for(int i = height-1; i >= 0; i--){
            for(int j = 0; j <= width-1; j++){
                listOfCoordinates.get(counter).setX(j);
                listOfCoordinates.get(counter).setY(i);
                counter++;
            }
        }
        listOfCoordinates.set(0, new Coordinate(0, height-1, CoordType.START));
        int lastIndex = listOfCoordinates.size() - 1;
        listOfCoordinates.set(lastIndex, new Coordinate(width - 1, 0, CoordType.END));
    }

    public void GenerateHelper(GeneratorNode current){
        System.out.println("CURRENT NODE: " + current.getX() + " " + current.getY());
        current.isVisited = true;
        current.setPath(true);
        visitedCells.add(current);
        isFound = false;
        while(!isFound){
            nextNode = getUnvisitedNeighbour(current);
            if (nextNode != null){
                nextNode.setPath(true);
                GenerateHelper(nextNode);
            }else {
                System.out.println("POP: " + visitedCells.peek().getX() + " " + visitedCells.peek().getY());
                visitedCells.pop();
                if(visitedCells.peek().getX() == 0 && visitedCells.peek().getY() == 0){
                    isFound = true;
                    return;
                }
                System.out.println("POP: " + visitedCells.peek().getX() + " " + visitedCells.peek().getY());
                visitedCells.pop();
                GenerateHelper(visitedCells.peek());

            }
        }
    }

    private GeneratorNode getUnvisitedNeighbour(GeneratorNode current) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        if(current.getY() == 0){
            directions[2][1] = 0;
        }
        if(current.getY() == width - 1){
            directions[3][1] = 0;
        }
        if(current.getX() == 0){
            directions[0][0] = 0;
        }
        if(current.getX() == height - 1){
            directions[1][0] = 0;
        }
        List<int[]> directionsList = Arrays.asList(directions);
        Collections.shuffle(directionsList);
        directions = directionsList.toArray(new int[directionsList.size()][]);
        for(int i = 0; i < 4; i++){
            neighbourVisited = false;
            nextNode = grid[current.getX() + directions[i][0]][current.getY() + directions[i][1]];
//            System.out.println("NEXT NODE: " + nextNode.getX() + " " + nextNode.getY());
//            System.out.println("DIRECTION: " + directions[i][0] + "," + directions[i][1]);
            if(!nextNode.isVisited){
                for (int j = 1; j >= -1; j--) {
//                    System.out.println(j);
                    if((j + nextNode.getX() >= 0) && (j + nextNode.getX() <= height - 1)) {
                        if (directions[i][0] == 0) {
                            nextNeighbour = grid[current.getX() + j][current.getY() + directions[i][1]];
                            if (nextNeighbour.isVisited) {
                                neighbourVisited = true;
//                                System.out.println("(1)NextNode: " + nextNode.getX() + " " + nextNode.getY() + " and Neighbour Visited: " + nextNeighbour.getX() + " " + nextNeighbour.getY());
                            }
                            if (((directions[i][1]*2) + nextNode.getY() >= 0) && ((directions[i][1]*2) + nextNode.getY() <= height-1)) {
                                nextNeighbour = grid[current.getX() + j][current.getY() + (directions[i][1]*2)];
                                if (nextNeighbour.isVisited) {
                                    neighbourVisited = true;
//                                    System.out.println("(1)NextNode: " + nextNode.getX() + " " + nextNode.getY() + " and Neighbour Visited: " + nextNeighbour.getX() + " " + nextNeighbour.getY());
                                }
                            }
                        }
                    }
                    if ((j + nextNode.getY() >= 0) && (j + nextNode.getY() <= width - 1)) {
                        if (directions[i][1] == 0) {
                            nextNeighbour = grid[current.getX() + directions[i][0]][current.getY() + j];
                            if (nextNeighbour.isVisited) {
                                neighbourVisited = true;
//                                System.out.println("(2)NextNode: " + nextNode.getX() + " " + nextNode.getY() + " and Neighbour Visited: " + nextNeighbour.getX() + " " + nextNeighbour.getY());
                            }
                            if (((directions[i][0]*2) + nextNode.getX() >= 0) && ((directions[i][0]*2) + nextNode.getX() <= width-1)) {
                                nextNeighbour = grid[current.getX() + (directions[i][0]*2)][current.getY() + j];
                                if (nextNeighbour.isVisited) {
                                    neighbourVisited = true;
//                                    System.out.println("(2)NextNode: " + nextNode.getX() + " " + nextNode.getY() + " and Neighbour Visited: " + nextNeighbour.getX() + " " + nextNeighbour.getY());
                                }
                            }
                        }
                    }
                }
                if(!neighbourVisited){
                    return nextNode;
                }
            }
        }
        return null;
    }

    public void PrintMaze(){
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                if (!this.grid[i][j].isPath){
                   System.out.print(" # ");
                } else if (this.grid[i][j] == this.grid[0][0]) {
                    System.out.print(" S ");
                } else if (this.grid[i][j] == this.grid[height - 1][width - 1]) {
                    System.out.print(" E ");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println("");
        }
    }

    public static void main(String[] args){
        MazeGeneration maze = new MazeGeneration(3,3);
        maze.GenerateMaze();
        maze.PrintMaze();
    }

}
