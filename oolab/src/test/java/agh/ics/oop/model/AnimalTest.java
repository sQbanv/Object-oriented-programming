package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    @Test
    void testToString() {
        Animal animal1 = new Animal();
        Animal animal2 = new Animal(new Vector2d(2,2));
        MoveValidator validator = new RectangularMap(4,4);

        animal2.move(MoveDirection.RIGHT,validator);

        assertEquals(animal1.toString(),"N");
        assertEquals(animal2.toString(),"E");
    }

    @Test
    void testIsAt() {
        Animal animal1 = new Animal(new Vector2d(2,2));

        assertTrue(animal1.isAt(new Vector2d(2,2)));
        assertFalse(animal1.isAt(new Vector2d(1,1)));
    }

    @Test
    void testDirection() {
        Animal animal1 = new Animal();
        Animal animal2 = new Animal(new Vector2d(4,4));

        assertEquals(animal1.getDirection(),MapDirection.NORTH);
        assertEquals(animal2.getDirection(),MapDirection.NORTH);
    }

    @Test
    void testDirection2(){
        Animal animal1 = new Animal();
        Animal animal2 = new Animal(new Vector2d(4,4));
        MoveValidator validator = new RectangularMap(4,4);

        animal1.move(MoveDirection.RIGHT,validator);
        animal2.move(MoveDirection.LEFT,validator);

        assertEquals(animal1.getDirection(),MapDirection.EAST);
        assertEquals(animal2.getDirection(),MapDirection.WEST);
    }

    @Test
    void testMove(){
        Animal animal1 = new Animal();
        Animal animal2 = new Animal(new Vector2d(4,4));
        Animal animal3 = new Animal(new Vector2d(0,0));
        MoveValidator validator = new RectangularMap(4,4);

        animal1.move(MoveDirection.FORWARD,validator);
        animal2.move(MoveDirection.FORWARD,validator);
        animal3.move(MoveDirection.BACKWARD,validator);

        assertEquals(animal1.getPosition(),new Vector2d(2,3));
        assertEquals(animal2.getPosition(),new Vector2d(4,4));
        assertEquals(animal3.getPosition(), new Vector2d(0,0));
    }
}