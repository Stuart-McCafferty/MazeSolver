package com.codeclan.examples.models;

public enum CoordType {
    START("START"),
    END("END"),
    PATH("PATH"),
    WALL("WALL");

    private String coordinateType;

    CoordType(String coordinateType) {
        this.coordinateType = coordinateType;
    }

    public String getCoordinateType(){
        return this.coordinateType;
    }

    public void setCoordinateType(String coordinateType) {
        this.coordinateType = coordinateType;
    }
}


