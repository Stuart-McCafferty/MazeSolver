public enum CoordType {
    START("START"),
    END("END"),
    PATH("PATH"),
    WALL("WALL");

    private final String coordinateType;

    CoordType(String coordinateType) {
        this.coordinateType = coordinateType;
    }

    public String getCoordinateType(){
        return this.coordinateType;
    }
}


