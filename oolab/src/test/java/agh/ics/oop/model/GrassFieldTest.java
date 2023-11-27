package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrassFieldTest {

    @Test
    void testCanMoveTo() {
        GrassField map = new GrassField(10);
        Animal animal1 = new Animal(new Vector2d(2, 2));

        try {
            map.place(animal1);
        } catch (PositionAlreadyOccupiedException e) {
            throw new RuntimeException(e);
        }

        assertTrue(map.canMoveTo(new Vector2d(1000, 1000)));
        assertTrue(map.canMoveTo(new Vector2d(-99999, -99999)));
        assertTrue(map.canMoveTo(new Vector2d(0, 0)));
        assertFalse(map.canMoveTo(new Vector2d(2,2)));
    }

    @Test
    void testPlaceValidPositions() {
        GrassField map = new GrassField(10);
        Animal animal1 = new Animal(new Vector2d(2,2));
        Animal animal2 = new Animal(new Vector2d(2,3));

        assertDoesNotThrow(() -> map.place(animal1));
        assertDoesNotThrow(() -> map.place(animal2));
    }

    @Test
    void testPlaceInvalidPositions(){
        GrassField map = new GrassField(10);
        Animal animal1 = new Animal(new Vector2d(2,2));
        Animal animal2 = new Animal(new Vector2d(2,2));

        assertDoesNotThrow(() -> map.place(animal1));
        assertThrows(PositionAlreadyOccupiedException.class, () -> map.place(animal2));
    }

    @Test
    void testMove() {
        GrassField map = new GrassField(10);
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
        GrassField map = new GrassField(0);
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
        GrassField map = new GrassField(0);
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
        GrassField map = new GrassField(1000);
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

        assertEquals(map.getElements().size(),1003);
    }
}