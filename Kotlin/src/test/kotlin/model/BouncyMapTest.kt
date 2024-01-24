import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import model.Animal
import model.BouncyMap
import model.MoveDirection
import model.Vector2d

class BouncyMapTest : BehaviorSpec({

    given("a BouncyMap") {
        val mapWidth = 10
        val mapHeight = 10
        val bouncyMap = BouncyMap(mapWidth, mapHeight)

        `when`("placing an animal on the map") {
            val animal = Animal(Vector2d(5, 5))

            bouncyMap.place(animal)

            then("the animal should be on the map at the specified position") {
                bouncyMap.isOccupied(Vector2d(5, 5)) shouldBe true
            }
        }

        `when`("placing an animal on an already occupied position") {
            val animal1 = Animal(Vector2d(8, 8))
            val animal2 = Animal(Vector2d(8, 8))

            bouncyMap.place(animal1)
            bouncyMap.place(animal2)

            then("the second animal should be placed in a different position") {
                bouncyMap.isOccupied(Vector2d(8, 8)) shouldBe true
                bouncyMap.isOccupied(animal2.position) shouldBe true
                animal1.position shouldNotBe animal2.position
            }
        }

        `when`("moving an animal forward") {
            val animal = Animal(Vector2d(1, 1))

            bouncyMap.place(animal)

            bouncyMap.place(animal, MoveDirection.FORWARD)

            then("the animal should move forward if the new position is valid") {
                bouncyMap.isOccupied(Vector2d(1, 2)) shouldBe true
                bouncyMap.isOccupied(Vector2d(1, 1)) shouldBe false
            }
        }

        `when`("moving an animal to an invalid position") {
            val animal = Animal(Vector2d(0, 0))

            bouncyMap.place(animal)

            bouncyMap.place(animal, MoveDirection.BACKWARD)

            then("the animal should not move to an invalid position") {
                bouncyMap.isOccupied(Vector2d(0, 0)) shouldBe true
                bouncyMap.isOccupied(Vector2d(-1, 0)) shouldBe false
            }
        }
    }
})