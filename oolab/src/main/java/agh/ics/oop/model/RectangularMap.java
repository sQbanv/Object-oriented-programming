package agh.ics.oop.model;

public class RectangularMap extends AbstractWorldMap{
    private final int width;
    private final int height;

    public RectangularMap(int width, int height){
        super();
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return super.canMoveTo(position) && position.follows(getCurrentBounds().lowerLeft()) && position.precedes(getCurrentBounds().upperRight());
    }

    @Override
    public Boundary getCurrentBounds(){
        return new Boundary(new Vector2d(0,0), new Vector2d(width,height));
    }
}
