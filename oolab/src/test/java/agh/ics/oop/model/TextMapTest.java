package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextMapTest {

    @Test
    void canMoveTo() {
        TextMap textList = new TextMap();
        textList.place("Ala");
        textList.place("ma");
        textList.place("sowoniedzwiedzia");

        assertTrue(textList.canMoveTo(0));
        assertTrue(textList.canMoveTo(1));
        assertTrue(textList.canMoveTo(2));
        assertFalse(textList.canMoveTo(-1));
        assertFalse(textList.canMoveTo(3));
    }

    @Test
    void place() {
        TextMap textList = new TextMap();
        textList.place("Ala");
        textList.place("ma");
        textList.place("sowoniedzwiedzia");

        assertEquals(textList.objectAt(0),"Ala");
        assertEquals(textList.objectAt(1),"ma");
        assertEquals(textList.objectAt(2),"sowoniedzwiedzia");
    }

    @Test
    void move() {
        TextMap textList = new TextMap();
        textList.place("Ala");
        textList.place("ma");
        textList.place("sowoniedzwiedzia");

        textList.move("ma", MoveDirection.FORWARD);

        assertEquals(textList.toString(),"[Ala, sowoniedzwiedzia, ma]");

        textList.move("ma", MoveDirection.FORWARD);

        assertEquals(textList.toString(),"[Ala, sowoniedzwiedzia, ma]");

        textList.move("sowoniedzwiedzia", MoveDirection.BACKWARD);

        assertEquals(textList.toString(),"[sowoniedzwiedzia, Ala, ma]");

        textList.move("Ala", MoveDirection.RIGHT);

        assertEquals(textList.toString(),"[sowoniedzwiedzia, Ala, ma]");

        textList.move("X", MoveDirection.FORWARD);

        assertEquals(textList.toString(),"[sowoniedzwiedzia, Ala, ma]");
    }

    @Test
    void isOccupied() {
        TextMap textList = new TextMap();
        textList.place("Ala");
        textList.place("ma");
        textList.place("sowoniedzwiedzia");
    }

    @Test
    void objectAt() {
        TextMap textList = new TextMap();
        textList.place("Ala");
        textList.place("ma");
        textList.place("sowoniedzwiedzia");

        assertEquals(textList.objectAt(0),"Ala");
        assertEquals(textList.objectAt(1),"ma");
        assertEquals(textList.objectAt(2),"sowoniedzwiedzia");
    }
}