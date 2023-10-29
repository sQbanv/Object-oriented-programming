package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class OptionsParserTest {
    @Test
    public void testOptionsParser(){
        String[] options1 = {"f","r","l","b"};
        String[] options2 = {"a","f","o","r","l","x","b","z"};

        MoveDirection[] test = {MoveDirection.FORWARD,MoveDirection.RIGHT,MoveDirection.LEFT,MoveDirection.BACKWARD};

        assertArrayEquals(OptionsParser.options(options1),test);
        assertArrayEquals(OptionsParser.options(options2),test);
    }
}
