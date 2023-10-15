package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

public class OptionsParser {
    public static MoveDirection[] options(String[] inputValues){
        int validOptions = 0;

        for(String option : inputValues){
            if(option.equals("f") || option.equals("b") || option.equals("r") || option.equals("l")){
                validOptions++;
            }
        }

        MoveDirection[] directions = new MoveDirection[validOptions];
        int k = 0;

        for(String direction : inputValues){
            switch (direction){
                case "f" -> {
                    directions[k] = MoveDirection.FORWARD;
                    k++;
                }
                case "b" -> {
                    directions[k] = MoveDirection.BACKWARD;
                    k++;
                }
                case "r" -> {
                    directions[k] = MoveDirection.RIGHT;
                    k++;
                }
                case "l" -> {
                    directions[k] = MoveDirection.LEFT;
                    k++;
                }
            }
        }

        return directions;
    }
}
