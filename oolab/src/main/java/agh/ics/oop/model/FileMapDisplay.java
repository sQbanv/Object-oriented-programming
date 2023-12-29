package agh.ics.oop.model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileMapDisplay implements MapChangeListener{

    @Override
    public void mapChanged(WorldMap<Animal, Vector2d> worldMap, String message) {
        try(PrintWriter writer = new PrintWriter(new FileWriter("map_"+worldMap.getID()+".log", true))){
            writer.println(message);
            writer.println(worldMap);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
