package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.PositionAlreadyOccupiedException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OptionsParserTest {
    @Test
    public void testOptionsParserValidOptions(){
        String[] options1 = {"f","r","l","b"};
        String[] options2 = {"forward","right","left","backward"};

        List<MoveDirection> test = List.of(MoveDirection.FORWARD,MoveDirection.RIGHT,
                MoveDirection.LEFT,MoveDirection.BACKWARD);

        assertArrayEquals(OptionsParser.options(options1).toArray(),test.toArray());
        assertArrayEquals(OptionsParser.options(options2).toArray(),test.toArray());
    }

    @Test
    public void testOptionsParserInvalidOptions(){
        String[] options = {"f","r","InvalidOption"};

        assertThrows(IllegalArgumentException.class, () -> OptionsParser.options(options));
    }
}
