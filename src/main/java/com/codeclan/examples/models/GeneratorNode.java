package com.codeclan.examples.models;

import javax.persistence.*;

public class GeneratorNode {

    private int x;

    private int y;

    public boolean isPath;

    public boolean isVisited;

    public GeneratorNode(){

    }
    public GeneratorNode(int x, int y, boolean isPath){
        this.x = x;
        this.y = y;
        this.isPath = isPath;
        this.isVisited = false;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public boolean isPath() {
        return isPath;
    }

    public void setPath(boolean path) {
        isPath = path;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public boolean isVisited(){ return this.isVisited;}


}
