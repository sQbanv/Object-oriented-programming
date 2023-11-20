package agh.ics.oop.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class AbstractWorldMap implements WorldMap<Animal, Vector2d> {
    protected final Map<Vector2d, Animal> animals = new HashMap<>();

    public abstract String toString();
    public abstract boolean canMoveTo(Vector2d position);

    @Override
    public boolean place(Animal animal){
        if(canMoveTo(animal.getPosition())) {
            animals.put(animal.getPosition(),animal);
            return true;
        }
        return false;
    }

    @Override
    public void move(Animal animal, MoveDirection direction){
        if(animals.containsKey(animal.getPosition())){
            Vector2d currPosition = animal.getPosition();
            animal.move(direction, this);
            animals.remove(currPosition);
            animals.put(animal.getPosition(),animal);
        }
    }

    public boolean isOccupied(Vector2d position){
        return animals.containsKey(position);
    }

    public WorldElement objectAt(Vector2d position){
        return animals.get(position);
    }

    public List<WorldElement> getElements(){
        return new LinkedList<>(animals.values());
    }
}
