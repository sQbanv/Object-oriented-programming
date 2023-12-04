package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import java.util.ArrayList;
import java.util.List;

public class OptionsParser {
    public static List<MoveDirection> options(String[] inputValues){
        List<MoveDirection> directions = new ArrayList<>();
        for (String direction : inputValues) {
            switch (direction.toLowerCase()){
                case "f", "forward" -> directions.add(MoveDirection.FORWARD);
                case "b", "backward" -> directions.add(MoveDirection.BACKWARD);
                case "r", "right" -> directions.add(MoveDirection.RIGHT);
                case "l", "left" -> directions.add(MoveDirection.LEFT);
                default -> throw new IllegalArgumentException(direction + " is not legal move specification");
            }
        }
        return directions;
    }
}
