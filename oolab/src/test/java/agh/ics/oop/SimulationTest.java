package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimulationTest {

    @Test
    void run() {
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

        Simulation simulation = new Simulation(directions, positions);
        simulation.run();

        List<Animal> animals = simulation.getAnimals();
        assertEquals(animals.get(0).getPosition(),new Vector2d(3,0));
        assertEquals(animals.get(1).getPosition(),new Vector2d(2,4));

        assertEquals(animals.get(0).getDirection(), MapDirection.SOUTH);
        assertEquals(animals.get(1).getDirection(), MapDirection.NORTH);
    }
}