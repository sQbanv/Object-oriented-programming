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
    void testPlaceValidPositions() {
        RectangularMap map = new RectangularMap(4,4);
        Animal animal1 = new Animal(new Vector2d(2,2));
        Animal animal2 = new Animal(new Vector2d(2,3));

        assertDoesNotThrow(() -> map.place(animal1));
        assertDoesNotThrow(() -> map.place(animal2));
    }

    @Test
    void testPlaceInvalidPositions(){
        RectangularMap map = new RectangularMap(4,4);
        Animal animal1 = new Animal(new Vector2d(2,2));
        Animal animal2 = new Animal(new Vector2d(2,2));

        assertDoesNotThrow(() -> map.place(animal1));
        assertThrows(PositionAlreadyOccupiedException.class, () -> map.place(animal2));
    }

    @Test
    void testMove() {
        RectangularMap map = new RectangularMap(4,4);
        Animal animal1 = new Animal(new Vector2d(2,2));
        Animal animal2 = new Animal(new Vector2d(4,4));
        Animal animal3 = new Animal(new Vector2d(1,1));

        try {
            map.place(animal1);
            map.place(animal2);
            map.place(animal3);
        } catch (PositionAlreadyOccupiedException e) {
            throw new RuntimeException(e);
        }

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

        try {
            map.place(animal1);
        } catch (PositionAlreadyOccupiedException e) {
            throw new RuntimeException(e);
        }

        assertTrue(map.isOccupied(new Vector2d(2,2)));
        assertFalse(map.isOccupied(new Vector2d(2,3)));
    }

    @Test
    void testObjectAt() {
        RectangularMap map = new RectangularMap(4,4);
        Animal animal1 = new Animal(new Vector2d(2,2));
        Animal animal2 = new Animal(new Vector2d(3,3));

        try {
            map.place(animal1);
        } catch (PositionAlreadyOccupiedException e) {
            throw new RuntimeException(e);
        }

        assertEquals(map.objectAt(new Vector2d(2,2)),animal1);
        assertNotEquals(map.objectAt(new Vector2d(2,2)),animal2);
        assertNull(map.objectAt(new Vector2d(4, 4)));
    }

    @Test
    void testGetElements(){
        RectangularMap map = new RectangularMap(4,4);
        Animal animal1 = new Animal(new Vector2d(2,2));
        Animal animal2 = new Animal(new Vector2d(4,4));
        Animal animal3 = new Animal(new Vector2d(1,1));

        try {
            map.place(animal1);
            map.place(animal2);
            map.place(animal3);
        } catch (PositionAlreadyOccupiedException e) {
            throw new RuntimeException(e);
        }

        assertEquals(map.getElements().size(),3);
        assertEquals(map.getElements().get(0),animal1);
        assertEquals(map.getElements().get(1),animal2);
        assertEquals(map.getElements().get(2),animal3);
    }
}