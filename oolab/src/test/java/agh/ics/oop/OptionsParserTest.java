package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class OptionsParserTest {
    @Test
    public void testOptionsParser(){
        String[] options1 = {"f","r","l","b"};
        String[] options2 = {"a","f","o","r","l","x","b","z"};

        List<MoveDirection> test = new ArrayList<>();
        test.add(MoveDirection.FORWARD);
        test.add(MoveDirection.RIGHT);
        test.add(MoveDirection.LEFT);
        test.add(MoveDirection.BACKWARD);

        assertArrayEquals(OptionsParser.options(options1).toArray(),test.toArray());
        assertArrayEquals(OptionsParser.options(options2).toArray(),test.toArray());
    }
}
