package model

interface MoveValidator {
    fun canMoveTo(position: Vector2d) : Boolean
}