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
        return "(" + position.getX() + "," + position.getY() + ") " + direction;
    }

    public boolean isAt(Vector2d position){
        return this.position.getX() == position.getX() && this.position.getY() == position.getY();
    }

    public void move(MoveDirection direction){
        switch (direction){
            case RIGHT -> this.direction = this.direction.next();
            case LEFT -> this.direction = this.direction.previous();
            case FORWARD -> {
                if(position.add(this.direction.toUnitVector()).follows(new Vector2d(0,0)) && position.add(this.direction.toUnitVector()).precedes(new Vector2d(4,4))){
                    position = position.add(this.direction.toUnitVector());
                }
            }
            case BACKWARD -> {
                if(position.subtract(this.direction.toUnitVector()).follows(new Vector2d(0,0)) && position.subtract(this.direction.toUnitVector()).precedes(new Vector2d(4,4))){
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
