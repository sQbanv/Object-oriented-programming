package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;


public class RectangularMap extends AbstractWorldMap{
    private final int width;
    private final int height;

    public RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        MapVisualizer mapVisualizer = new MapVisualizer(this);
        return mapVisualizer.draw(new Vector2d(0,0),new Vector2d(width,height));
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(new Vector2d(0, 0)) && position.precedes(new Vector2d(width, height)) && !isOccupied(position);
    }
}
