package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GrassField extends AbstractWorldMap{
    protected final Map<Vector2d, Grass> grassFields = new HashMap<>();

    public GrassField(int numberOfGrass){
        placeGrassOnMap(numberOfGrass);
    }

    private void placeGrassOnMap(int numberOfGrass){
        randomPositionGenerator positionGenerator = new randomPositionGenerator((int) Math.sqrt(numberOfGrass * 10),(int) Math.sqrt(numberOfGrass * 10),numberOfGrass);
        while(positionGenerator.hasNext()){
            Vector2d randomPosition = positionGenerator.next();
            grassFields.put(randomPosition, new Grass(randomPosition));
        }
    }

    @Override
    public String toString() {
        Vector2d lowerLeft = new Vector2d(Integer.MAX_VALUE,Integer.MAX_VALUE);
        Vector2d upperRight = new Vector2d(Integer.MIN_VALUE,Integer.MIN_VALUE);

        for (Vector2d position : animals.keySet()){
            lowerLeft = lowerLeft.lowerLeft(position);
            upperRight = upperRight.upperRight(position);
        }

        for (Vector2d position : grassFields.keySet()){
            lowerLeft = lowerLeft.lowerLeft(position);
            upperRight = upperRight.upperRight(position);
        }

        MapVisualizer mapVisualizer = new MapVisualizer(this);
        return mapVisualizer.draw(lowerLeft,upperRight);
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        return super.objectAt(position) != null ? super.objectAt(position) : grassFields.get(position);
    }

    @Override
    public List<WorldElement> getElements(){
        List<WorldElement> allElements = super.getElements();
        allElements.addAll(grassFields.values());
        return allElements;
    }
}
