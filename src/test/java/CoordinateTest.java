import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CoordinateTest {

    Coordinate coordinate1;
    Coordinate coordinate2;
    Coordinate coordinate3;
    Coordinate coordinate4;

    @Before
    public void SetUp(){
        coordinate1 = new Coordinate(0,0,CoordType.START);
        coordinate2 = new Coordinate(0,1, CoordType.WALL);
        coordinate3 = new Coordinate(1,0, CoordType.PATH);
        coordinate4 = new Coordinate(2,0, CoordType.END);
    }

    @Test
    public void hasXCoordinate(){
        assertEquals(0, coordinate1.getX());
    }

    @Test
    public void hasYCoordinate(){
        assertEquals(1, coordinate2.getY());
    }

    @Test
    public void hasTypeStart(){
        assertEquals("START", coordinate1.coordType.getCoordinateType());
    }

    @Test
    public void hasTypeWall(){
        assertEquals("WALL", coordinate2.coordType.getCoordinateType());
    }

    @Test
    public void hasTypePath(){
        assertEquals("PATH", coordinate3.coordType.getCoordinateType());
    }

    @Test
    public void hasTypeEnd(){
        assertEquals("END", coordinate4.coordType.getCoordinateType());
    }



}
