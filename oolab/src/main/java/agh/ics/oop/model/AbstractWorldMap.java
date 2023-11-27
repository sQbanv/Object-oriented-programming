package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class AbstractWorldMap implements WorldMap<Animal, Vector2d> {
    protected final Map<Vector2d, Animal> animals = new HashMap<>();
    protected final MapVisualizer mapVisualizer = new MapVisualizer(this);
    protected final LinkedList<MapChangeListener> mapChangeListeners = new LinkedList<>();

    public abstract Boundary getCurrentBounds();

    public String toString(){
        return mapVisualizer.draw(getCurrentBounds().lowerLeft(),getCurrentBounds().upperRight());
    }

    @Override
    public void place(Animal animal) throws PositionAlreadyOccupiedException {
        if(canMoveTo(animal.getPosition())) {
            animals.put(animal.getPosition(),animal);
            mapChanged("Animal place: %s, %s".formatted(animal.getPosition(),animal.getDirection()));
        } else {
            throw new PositionAlreadyOccupiedException(animal.getPosition());
        }
    }

    @Override
    public void move(Animal animal, MoveDirection direction){
        if(animals.containsKey(animal.getPosition())){
            Vector2d currPosition = animal.getPosition();
            MapDirection currDirection = animal.getDirection();

            animal.move(direction, this);
            animals.remove(currPosition);
            animals.put(animal.getPosition(),animal);

            if(!currPosition.equals(animal.getPosition())){
                mapChanged("Animal move: %s -> %s".formatted(currPosition,animal.getPosition()));
            } else if(!currDirection.equals(animal.getDirection())) {
                mapChanged("Animal move: %s -> %s".formatted(currDirection,animal.getDirection()));
            } else {
                mapChanged("Animal not move");
            }
        }
    }

    public boolean canMoveTo(Vector2d position){
        return !isOccupied(position);
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

    public void addListener(MapChangeListener listener){
        mapChangeListeners.add(listener);
    }

    public void removeListener(MapChangeListener listener){
        mapChangeListeners.remove(listener);
    }

    public void mapChanged(String message){
        for (MapChangeListener listener : mapChangeListeners) {
            listener.mapChanged(this, message);
        }
    }
}
