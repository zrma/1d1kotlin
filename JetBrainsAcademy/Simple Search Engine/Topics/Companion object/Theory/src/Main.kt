fun main() {
    /* prints 7 */
    @Suppress("RedundantCompanionReference") println(Player.Properties.defaultSpeed)

    /* prints 7 too */
    @Suppress("RedundantCompanionReference") println(PlayerOmitted.Companion.defaultSpeed)

    /* prints 7 */
    @Suppress("RedundantCompanionReference") println(PlayerFinal.Properties.defaultSpeed)

    /* also prints 7 */
    println(PlayerFinal.defaultSpeed)

    /* prints 13 */
    println(PlayerFinal.Factory.create(13).id)

    /*prints WUF-WUF*/
    System.out.println(Dog.createSound())
}

class Player(val id: Int) {
    companion object Properties {
        /* Default player speed in playing field - 7 cells per turn */
        const val defaultSpeed = 7

        fun calcMovePenalty(cell: Int): Int {
            /* calc move speed penalty */
            return defaultSpeed - cell % 3
        }
    }
}

class PlayerOmitted(val id: Int) {
    companion object {
        /* Default player speed in playing field - 7 cells per turn */
        const val defaultSpeed = 7

        fun calcMovePenalty(cell: Int): Int {
            /* calc move speed penalty */
            return defaultSpeed - cell % 3
        }
    }
}

class Deck {
    companion object {
        val size = 10
        val height = 2
        fun volume(bottom: Int, height: Int) = bottom * height
    }

    val square = size * size // 100
    val volume = volume(square, height) // 200
}

class Deck1 {
    companion object {
        val size = 10
    }
    val size = 2
    val square = Companion.size * Companion.size // 100
}

class Deck2() {
    val size = 2
    object Properties {
        // val defaultSize = size // you cannot get this variable
    }
}

class BadClass {
    companion object Properties {}

    // Compilation error
    // Error: Only one companion object is allowed per class
    // companion object Factory {}
}

class PlayerFinal(val id: Int) {
    companion object Properties {
        /* Default player speed in playing field - 7 cells per turn */
        const val defaultSpeed = 7

        fun calcMovePenalty(cell: Int): Int {
            /* calc move speed penalty */
            return defaultSpeed - cell % 3
        }
    }

    /* creates a new instance of Player */
    object Factory {
        fun create(playerId: Int): Player {
            return Player(playerId)
        }
    }
}

object OuterSingleton {
    // Modifier 'companion' is not applicable inside 'object'
    // companion object InnerSingleton {
    // }
}

// Java Example
// class Dog {
//     public static int numOfPaws = 4;
//
//     public static String createSound() {
//         return "WUF-WUF";
//     }
// }
class Dog {
    companion object {
        const val numOfPaws: Int = 4
        fun createSound(): String = "WUF-WUF"
    }
}
