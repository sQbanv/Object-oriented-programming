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
        return this.position.getX() == position.getX() && this.position.getY() == position.getY();
    }

    public void move(MoveDirection direction, MoveValidator validator){
        switch (direction){
            case RIGHT -> this.direction = this.direction.next();
            case LEFT -> this.direction = this.direction.previous();
            case FORWARD -> {
                if(validator.canMoveTo(position.add(this.direction.toUnitVector()))){
                    position = position.add(this.direction.toUnitVector());
                }
            }
            case BACKWARD -> {
                if(validator.canMoveTo(position.subtract(this.direction.toUnitVector()))){
                    position = position.subtract(this.direction.toUnitVector());
                }
            }
        }
    }

    public MapDirection getDirection() {
        return direction;
    }

    public Vector2d getPosition() {
        return position;
    }
}
