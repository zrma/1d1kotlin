fun main() {
    /* prints 7 */
    println(Player.Properties.defaultSpeed)

    /* prints 13 */
    println(Player.Factory.create(13).id)
}

object Game {
    object Properties {
        val maxPlayersCount = 13
        val maxGameDurationInSec = 2400
    }

    object Info {
        val name = "My super game"
    }
}

object PlayingField {
    val players = arrayListOf<Player>()

    fun getAllPlayers(): Array<Player> {
        return players.toTypedArray()
    }

    fun isPlayerInGame(player: Player): Boolean {
        return players.contains(player)
    }
}

fun startNewGameTurn() {
    val players = PlayingField.getAllPlayers()
    if (players.size < 2) {
        return println("The game cannot be continued without players")
    }
    for (player in players) {
        nextPlayerTurn(player)
    }
}

fun nextPlayerTurn(player: Player) {
    if (!PlayingField.isPlayerInGame(player)) {
        return println("Current player lost. Next...")
    }
    /* Player actions here */
}

object PlayerProperties {
    /* Default player speed in playing field – 7 cells per turn */
    val defaultSpeed = 7

    fun calcMovePenalty(cell: Int): Int {
        /* calc move speed penalty */
        return defaultSpeed - cell
    }
}

class OuterClass {
    // outer class code
    class NestedClass {
        // nested class code
    }
}

class Player(val id: Int) {
    object Properties {
        /* Default player speed in playing field – 7 cells per turn */
        val defaultSpeed = 7

        fun calcMovePenalty(cell: Int): Int {
            /* calc move speed penalty */
            return defaultSpeed - cell
        }
    }
    val speed = 7
    val superSpeed = Properties.defaultSpeed * 2 // 14

    /* creates a new instance of Player */
    object Factory {
        fun create(playerId: Int): Player {
            return Player(playerId)
        }
    }
}
