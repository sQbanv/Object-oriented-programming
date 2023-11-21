package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangularMapTest {

    @Test
    void testCanMoveTo() {
        RectangularMap map = new RectangularMap(4,4);

        assertTrue(map.canMoveTo(new Vector2d(2,1)));
        assertTrue(map.canMoveTo(new Vector2d(4,4)));
        assertTrue(map.canMoveTo(new Vector2d(0,0)));
        assertFalse(map.canMoveTo(new Vector2d(5,4)));
        assertFalse(map.canMoveTo(new Vector2d(0,-1)));
    }

    @Test
    void testPlace() {
        RectangularMap map = new RectangularMap(4,4);
        Animal animal1 = new Animal(new Vector2d(2,2));
        Animal animal2 = new Animal(new Vector2d(2,2));
        Animal animal3 = new Animal(new Vector2d(2,3));

        assertTrue(map.place(animal1));
        assertFalse(map.place(animal2));
        assertTrue(map.place(animal3));
    }

    @Test
    void testMove() {
        RectangularMap map = new RectangularMap(4,4);
        Animal animal1 = new Animal(new Vector2d(2,2));
        Animal animal2 = new Animal(new Vector2d(4,4));
        Animal animal3 = new Animal(new Vector2d(1,1));

        map.place(animal1);
        map.place(animal2);
        map.place(animal3);

        map.move(animal1, MoveDirection.FORWARD);
        map.move(animal2, MoveDirection.FORWARD);
        map.move(animal3, MoveDirection.RIGHT);

        assertEquals(animal1.getPosition(),new Vector2d(2,3));
        assertNotEquals(animal2.getPosition(), new Vector2d(5,4));
        assertEquals(animal3.getDirection(),MapDirection.EAST);
    }

    @Test
    void testIsOccupied() {
        RectangularMap map = new RectangularMap(4,4);
        Animal animal1 = new Animal(new Vector2d(2,2));

        map.place(animal1);

        assertTrue(map.isOccupied(new Vector2d(2,2)));
        assertFalse(map.isOccupied(new Vector2d(2,3)));
    }

    @Test
    void testObjectAt() {
        RectangularMap map = new RectangularMap(4,4);
        Animal animal1 = new Animal(new Vector2d(2,2));
        Animal animal2 = new Animal(new Vector2d(3,3));

        map.place(animal1);

        assertEquals(map.objectAt(new Vector2d(2,2)),animal1);
        assertNotEquals(map.objectAt(new Vector2d(2,2)),animal2);
        assertNull(map.objectAt(new Vector2d(4, 4)));
    }
}