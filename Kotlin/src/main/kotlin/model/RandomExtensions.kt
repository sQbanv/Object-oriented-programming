package model

fun <T> Map<Vector2d, T>.randomPosition() : Vector2d? = this.keys.toList().randomOrNull();

fun <T> Map<Vector2d, T>.randomFreePosition(mapSize: Vector2d) : Vector2d? {
    val allPositions = generateAllPositions(mapSize)
    val takenPositions = this.keys.toSet()

    val freePositions = allPositions - takenPositions

    return freePositions.toList().randomOrNull()
}

private fun generateAllPositions(mapSize: Vector2d) : Set<Vector2d> {
    val positions = mutableSetOf<Vector2d>()
    for (x in 0 until mapSize.x){
        for (y in 0 until mapSize.y){
            positions.add(Vector2d(x,y))
        }
    }
    return positions
}