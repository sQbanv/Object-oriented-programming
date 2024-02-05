package model

enum class MapDirection {
    NORTH, EAST, SOUTH, WEST;

    override fun toString() : String {
        return when (this){
            NORTH -> "North"
            EAST -> "East"
            SOUTH -> "South"
            WEST -> "West"
        }
    }

    fun next() : MapDirection {
        return when (this) {
            NORTH -> EAST
            EAST -> SOUTH
            SOUTH -> WEST
            WEST -> NORTH
        }
    }

    fun previous() : MapDirection {
        return when (this) {
            NORTH -> WEST
            EAST -> NORTH
            SOUTH -> EAST
            WEST -> SOUTH
        }
    }
}