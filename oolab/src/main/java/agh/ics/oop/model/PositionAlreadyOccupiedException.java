package agh.ics.oop.model;

public class PositionAlreadyOccupiedException extends Exception{
    private final Vector2d position;

    public PositionAlreadyOccupiedException(Vector2d position){
        super("Position " + position + " is already occupied");
        this.position = position;
    }

    public Vector2d getPosition() {
        return position;
    }
}
