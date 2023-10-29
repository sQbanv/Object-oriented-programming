package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {
    @Test
    public void testEquals(){
        Vector2d v1 = new Vector2d(2,5);
        Vector2d v2 = new Vector2d(2,5);
        Vector2d v3 = new Vector2d(4,5);

        assertTrue(v1.equals(v2));
        assertFalse(v2.equals(v3));
    }
    @Test
    public void testToString(){
        Vector2d v1 = new Vector2d(2,5);
        Vector2d v2 = new Vector2d(-1,0);

        assertEquals(v1.toString(),"(2,5)");
        assertEquals(v2.toString(),"(-1,0)");
    }
    @Test
    public void testPrecedes(){
        Vector2d v1 = new Vector2d(1,5);
        Vector2d v2 = new Vector2d(4,7);

        assertTrue(v1.precedes(v2));
        assertFalse(v2.precedes(v1));
    }
    @Test
    public void testFollows(){
        Vector2d v1 = new Vector2d(1,5);
        Vector2d v2 = new Vector2d(4,7);

        assertFalse(v1.follows(v2));
        assertTrue(v2.follows(v1));
    }
    @Test
    public void testUpperRight(){
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(3,4);

        assertEquals(v1.upperRight(v2),new Vector2d(3,4));
        assertEquals(v2.upperRight(v1),new Vector2d(3,4));
    }
    @Test
    public void testLowerLeft(){
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(3,4);

        assertEquals(v1.lowerLeft(v2),new Vector2d(1,2));
        assertEquals(v2.lowerLeft(v1),new Vector2d(1,2));
    }
    @Test
    public void testAdd(){
        Vector2d v1 = new Vector2d(1,-1);
        Vector2d v2 = new Vector2d(-2,3);

        assertEquals(v1.add(v2),new Vector2d(-1,2));
    }
    @Test
    public void testSubtract(){
        Vector2d v1 = new Vector2d(1,-1);
        Vector2d v2 = new Vector2d(-2,3);

        assertEquals(v1.subtract(v2),new Vector2d(3,-4));
        assertEquals(v2.subtract(v1),new Vector2d(-3,4));
    }
    @Test
    public void testOpposite(){
        Vector2d v1 = new Vector2d(1,-1);
        Vector2d v2 = new Vector2d(-2,3);
        Vector2d v3 = new Vector2d(4,0);

        assertEquals(v1.opposite(),new Vector2d(-1,1));
        assertEquals(v2.opposite(),new Vector2d(2,-3));
        assertEquals(v3.opposite(),new Vector2d(-4,0));
    }
}
