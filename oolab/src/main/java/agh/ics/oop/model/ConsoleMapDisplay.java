package agh.ics.oop.model;

public class ConsoleMapDisplay implements MapChangeListener{
    private int updateNumber = 1;
    @Override
    public void mapChanged(WorldMap<Animal, Vector2d> worldMap, String message) {
        System.out.println(updateNumber + " | " + message);
        System.out.println(worldMap);
        updateNumber++;
    }
}
