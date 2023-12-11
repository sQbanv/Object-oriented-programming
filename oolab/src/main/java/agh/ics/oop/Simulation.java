package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.List;

public class Simulation implements Runnable{
    private final List<MoveDirection> directions;
    private final List<Animal> animals;
    private final WorldMap<Animal, Vector2d> map;

    public Simulation(List<MoveDirection> directions, List<Vector2d> positions, WorldMap<Animal, Vector2d> map){
        this.directions = directions;
        this.map = map;
        this.animals = createAnimals(positions);
    }

    private List<Animal> createAnimals(List<Vector2d> positions){
        List<Animal> createdAnimals = new ArrayList<>();
        for(Vector2d position : positions){
            try {
                Animal animal = new Animal(position);
                map.place(animal);
                createdAnimals.add(animal);
            } catch (PositionAlreadyOccupiedException ex){
                System.out.println(ex.getMessage());
            }
        }
        return createdAnimals;
    }

    @Override
    public void run(){
        for (int i=0; i<directions.size(); i++){
            map.move(animals.get(i % animals.size()), directions.get(i));
        }
    }

    public List<Animal> getAnimals() {
        return animals;
    }
}
