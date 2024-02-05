package model

import kotlin.collections.HashMap

class BouncyMap(val width: Int, val height: Int) : WorldMap {
    val animals : HashMap<Vector2d, Animal> = HashMap()

    override fun canMoveTo(position: Vector2d) = position >= Vector2d(0,0) && position <= Vector2d(width,height)

    override fun objectAt(position: Vector2d): Animal? {
        return if(animals.containsKey(position)){
            animals.get(position)
        } else {
            null
        }
    }

    override fun isOccupied(position: Vector2d): Boolean = animals.containsKey(position)

    override fun place(animal: Animal, direction: MoveDirection) {
        if(animals.containsValue(animal)){
            animals.remove(animal.position)
            animal.move(direction, this)
            bounce(animal)
        } else {
            bounce(animal)
        }
    }

    private fun bounce(animal: Animal) {
        if(isOccupied(animal.position)){
            var randomPosition = animals.randomFreePosition(Vector2d(width, height))
            if(randomPosition != null){
                animal.position = randomPosition
                animals.set(randomPosition, animal)
            } else {
                randomPosition = animals.randomPosition()
                if(randomPosition != null){
                    animal.position = randomPosition
                    animals.set(randomPosition, animal)
                }
            }
        } else {
            animals.set(animal.position, animal)
        }
    }
}