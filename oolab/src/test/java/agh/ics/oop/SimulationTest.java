package agh.ics.oop;

import agh.ics.oop.model.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimulationTest {

    @Test
    void run1() {
        List<MoveDirection> directions = List.of(
                MoveDirection.FORWARD,MoveDirection.BACKWARD,
                MoveDirection.RIGHT,MoveDirection.LEFT,
                MoveDirection.FORWARD,MoveDirection.FORWARD,
                MoveDirection.RIGHT,MoveDirection.RIGHT,
                MoveDirection.FORWARD,MoveDirection.FORWARD,
                MoveDirection.FORWARD,MoveDirection.FORWARD,
                MoveDirection.FORWARD,MoveDirection.FORWARD,
                MoveDirection.FORWARD,MoveDirection.FORWARD);

        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));

        Simulation simulation = new Simulation(directions, positions, new RectangularMap(4,4));
        simulation.run();

        List<Animal> animals = simulation.getAnimals();
        assertEquals(animals.get(0).getPosition(),new Vector2d(2,0));
        assertEquals(animals.get(1).getPosition(),new Vector2d(3,4));

        assertEquals(animals.get(0).getDirection(), MapDirection.SOUTH);
        assertEquals(animals.get(1).getDirection(), MapDirection.NORTH);
    }

    @Test
    void placeTest(){
        List<MoveDirection> directions = List.of();

        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(10,4),new Vector2d(2,2), new Vector2d(9,9),
                new Vector2d(-1,-1),new Vector2d(9,9), new Vector2d(5,7));

        Simulation simulation = new Simulation(directions, positions, new RectangularMap(9,9));
        simulation.run();

        List<Animal> animals = simulation.getAnimals();

        assertEquals(animals.size(),3);
        assertEquals(animals.get(0).getPosition(),new Vector2d(2,2));
        assertEquals(animals.get(1).getPosition(),new Vector2d(9,9));
        assertEquals(animals.get(2).getPosition(),new Vector2d(5,7));
    }
}