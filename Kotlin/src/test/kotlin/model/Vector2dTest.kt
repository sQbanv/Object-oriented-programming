import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import model.*

class Vector2dTest : BehaviorSpec({

    given("a positions") {
        val position1 = Vector2d(5,5)
        val position2 = Vector2d(1,2)

        `when`("adding two positions") {
            val result = position1 + position2

            then("the position should be") {
                result shouldBe Vector2d(6,7)
            }
        }

        `when`("subtracting two positions") {
            val result = position1 - position2

            then("the position should be") {
                result shouldBe Vector2d(4,3)
            }
        }

        `when`("comparing two positions"){
            val result1 = position1 >= position2
            val result2 = position1 <= position2

            then("the comparison should be"){
                result1 shouldBe true
                result2 shouldBe false
            }
        }
    }
})