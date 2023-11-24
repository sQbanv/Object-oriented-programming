package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrassFieldTest {

    @Test
    void testCanMoveTo() {
        GrassField map = new GrassField(10);
        Animal animal1 = new Animal(new Vector2d(2, 2));

        map.place(animal1);

        assertTrue(map.canMoveTo(new Vector2d(1000, 1000)));
        assertTrue(map.canMoveTo(new Vector2d(-99999, -99999)));
        assertTrue(map.canMoveTo(new Vector2d(0, 0)));
        assertFalse(map.canMoveTo(new Vector2d(2,2)));
    }

    @Test
    void testPlace() {
        GrassField map = new GrassField(10);
        Animal animal1 = new Animal(new Vector2d(2,2));
        Animal animal2 = new Animal(new Vector2d(2,2));
        Animal animal3 = new Animal(new Vector2d(2,3));

        assertTrue(map.place(animal1));
        assertFalse(map.place(animal2));
        assertTrue(map.place(animal3));
    }

    @Test
    void testMove() {
        GrassField map = new GrassField(10);
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
        GrassField map = new GrassField(0);
        Animal animal1 = new Animal(new Vector2d(2,2));

        map.place(animal1);

        assertTrue(map.isOccupied(new Vector2d(2,2)));
        assertFalse(map.isOccupied(new Vector2d(2,3)));
    }

    @Test
    void testObjectAt() {
        GrassField map = new GrassField(0);
        Animal animal1 = new Animal(new Vector2d(2,2));
        Animal animal2 = new Animal(new Vector2d(3,3));

        map.place(animal1);

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

        map.place(animal1);
        map.place(animal2);
        map.place(animal3);

        assertEquals(map.getElements().size(),1003);
    }
}