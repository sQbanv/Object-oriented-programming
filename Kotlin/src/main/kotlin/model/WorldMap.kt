package model

interface WorldMap : MoveValidator {
    fun place(animal: Animal, direction: MoveDirection = MoveDirection.FORWARD)

    fun isOccupied(position: Vector2d) : Boolean

    fun objectAt(position: Vector2d) : Animal?
}