package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OptionsParser {
    public static List<MoveDirection> options(String[] inputValues){
        return Stream.of(inputValues)
                .map(OptionsParser::parseDirection)
                .toList();
    }

    private static MoveDirection parseDirection(String direction){
        return switch (direction.toLowerCase()){
            case "f", "forward" -> MoveDirection.FORWARD;
            case "b", "backward" -> MoveDirection.BACKWARD;
            case "r", "right" -> MoveDirection.RIGHT;
            case "l", "left" -> MoveDirection.LEFT;
            default -> throw new IllegalArgumentException(direction + " is not legal move specification");
        };
    }
}
