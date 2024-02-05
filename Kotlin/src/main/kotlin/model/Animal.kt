package model

class Animal(var position: Vector2d = Vector2d(2, 2)) {
    var direction: MapDirection = MapDirection.NORTH

    override fun toString(): String {
        return when (direction) {
            MapDirection.NORTH -> "N"
            MapDirection.EAST -> "E"
            MapDirection.SOUTH -> "S"
            MapDirection.WEST -> "W"
        }
    }

    fun isAt(position: Vector2d) = this.position == position

    fun move(direction: MoveDirection, validator: MoveValidator) {
        when (direction) {
            MoveDirection.RIGHT -> this.direction = this.direction.next()
            MoveDirection.LEFT -> this.direction = this.direction.previous()
            MoveDirection.FORWARD, MoveDirection.BACKWARD -> moveForwardOrBackward(direction, validator)
        }
    }

    private fun moveForwardOrBackward(direction: MoveDirection, validator: MoveValidator) {
        val newPosition: Vector2d
        if (direction == MoveDirection.FORWARD) {
            newPosition = position + this.direction.toUnitVector()
        } else {
            newPosition = position - this.direction.toUnitVector()
        }
        if (validator.canMoveTo(newPosition)) {
            position = newPosition
        }
    }
}