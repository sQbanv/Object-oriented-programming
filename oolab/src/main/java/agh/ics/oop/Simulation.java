package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private final List<MoveDirection> directions;
    private final List<Animal> animals;

    public Simulation(List<MoveDirection> directions, List<Vector2d> positions){
        this.directions = directions;
        animals = new ArrayList<>();
        for (Vector2d position : positions) {
            animals.add(new Animal(position));
        }
    }

    public void run(){
        for (int i=0; i<directions.size(); i++){
            animals.get(i % animals.size()).move(directions.get(i));
            System.out.println("Zwierzę " + (i % animals.size()) + " : " + animals.get(i % animals.size()));
        }
    }

    public List<Animal> getAnimals() {
        return animals;
    }
}
