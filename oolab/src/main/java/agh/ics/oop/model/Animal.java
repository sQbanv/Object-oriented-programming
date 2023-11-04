package agh.ics.oop.model;

public class Animal {
    private MapDirection direction = MapDirection.NORTH;
    private Vector2d position;

    public Animal(){
        this(new Vector2d(2,2));
    }

    public Animal(Vector2d position){
        this.position = position;
    }

    public String toString(){
        return switch (direction){
            case NORTH -> "N";
            case EAST ->  "E";
            case SOUTH -> "S";
            case WEST ->  "W";
        };
    }

    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }

    public void move(MoveDirection direction, MoveValidator validator){
        switch (direction){
            case RIGHT -> this.direction = this.direction.next();
            case LEFT -> this.direction = this.direction.previous();
            case FORWARD, BACKWARD -> moveForwardOrBackward(direction, validator);
        }
    }

    private void moveForwardOrBackward(MoveDirection direction, MoveValidator validator){
        Vector2d newPosition;
        if(direction == MoveDirection.FORWARD){
            newPosition = position.add(this.direction.toUnitVector());
        } else {
            newPosition = position.subtract(this.direction.toUnitVector());
        }
        if(validator.canMoveTo(newPosition)){
            position = newPosition;
        }
    }

    public MapDirection getDirection() {
        return direction;
    }

    public Vector2d getPosition() {
        return position;
    }
}
