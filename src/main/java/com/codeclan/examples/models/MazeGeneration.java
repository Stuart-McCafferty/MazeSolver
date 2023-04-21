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


    public MazeGeneration(int height, int width){
        this.height = height;
        this.width = width;
        this.grid = new GeneratorNode[height][width];
        isFound = Boolean.FALSE;
        nextNode = new GeneratorNode();
        nextNeighbour = new GeneratorNode();
        neighbourVisited = Boolean.FALSE;
    }

    public void GenerateMaze(){
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
        GenerateHelper(grid[randomInt][randomInt2]);

    }

    public void GenerateHelper(GeneratorNode current){
        current.isVisited = true;
        current.setPath(true);
        isFound = false;
        while(!isFound){
            nextNode = getUnvisitedNeighbour(current);
            if (nextNode != null){
                nextNode.setPath(true);
                isFound = true;
            }

            //check if that cell has been visited
            //if false, check all around this new cell excluding current and parent to see if they are visited
            //if false set currenet to parent and new cell to current and set isFound to true
            //call GenerateHelper(current, parent)

            //if all nodes next to current have been visited remove from (queue or stack)
            // call GenerateHelper(next in queue or stack, its parents
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
        System.out.println(Arrays.deepToString(directions));
        for(int i = 0; i < 4; i++){
            neighbourVisited = false;
            nextNode = grid[current.getX() + directions[i][0]][current.getY() + directions[i][1]];
            if(!nextNode.isVisited){
                for (int j = 1; j >= -1; j--) {
                    if((j + nextNode.getX() >= 0) && (j + nextNode.getX() <= height - 1)) {
                        if (directions[i][0] == 0) {
                            nextNeighbour = grid[current.getX() + j][current.getY() + directions[i][1]];
                            if (nextNeighbour.isVisited) {
                                neighbourVisited = true;
                            }
                        }
                    }
                    if ((j + nextNode.getY() >= 0) && (j + nextNode.getY() <= width - 1)) {
                        if (directions[i][1] == 0) {
                            nextNeighbour = grid[current.getX() + directions[i][0]][current.getY() + j];
                            if (nextNeighbour.isVisited) {
                                neighbourVisited = true;
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
        MazeGeneration maze = new MazeGeneration(7,7);
        maze.GenerateMaze();
        maze.PrintMaze();
    }

}
