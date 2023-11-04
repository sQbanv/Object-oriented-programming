package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.WorldMap;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private final List<MoveDirection> directions;
    private final List<Animal> animals;
    private final WorldMap map;

    public Simulation(List<MoveDirection> directions, List<Vector2d> positions, WorldMap map){
        this.directions = directions;
        this.map = map;
        this.animals = createAnimals(positions);
    }

    private List<Animal> createAnimals(List<Vector2d> positions){
        List<Animal> createdAnimals = new ArrayList<>();
        for(Vector2d position : positions){
            if(map.place(new Animal(position))){
                createdAnimals.add(new Animal(position));
            }
        }
        return createdAnimals;
    }

    public void run(){
        System.out.println(map);
        for (int i=0; i<directions.size(); i++){
            map.move(animals.get(i % animals.size()), directions.get(i));
            System.out.println(map);
        }
    }

    public List<Animal> getAnimals() {
        return animals;
    }
}
