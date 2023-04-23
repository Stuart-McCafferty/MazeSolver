package com.codeclan.examples.models;

import javax.persistence.*;

public class Coordinate {

    private int x;

    private int y;

    public CoordType coordType;


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

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
