package chess

fun main() {
    val title = "Pawns-Only Chess"
    println(title)

    println("First Player's name:")
    val player0 = readLine()!!
    println("Second Player's name:")
    val player1 = readLine()!!

    val board =
        Board(
            arrayListOf(
                arrayListOf(" ", " ", " ", " ", " ", " ", " ", " "),
                arrayListOf("W", "W", "W", "W", "W", "W", "W", "W"),
                arrayListOf(" ", " ", " ", " ", " ", " ", " ", " "),
                arrayListOf(" ", " ", " ", " ", " ", " ", " ", " "),
                arrayListOf(" ", " ", " ", " ", " ", " ", " ", " "),
                arrayListOf(" ", " ", " ", " ", " ", " ", " ", " "),
                arrayListOf("B", "B", "B", "B", "B", "B", "B", "B"),
                arrayListOf(" ", " ", " ", " ", " ", " ", " ", " "),
            )
        )
    board.print()

    var firstPlayer = true
    while (true) {
        if (firstPlayer) {
            println("$player0's turn:")
        } else {
            println("$player1's turn:")
        }

        val input = readLine()!!
        if (input == "exit") {
            println("Bye!")
            break
        }

        val valid = Regex("[a-h][1-8][a-h][1-8]").matches(input)
        if (!valid) {
            println("Invalid Input")
            continue
        }
        if (!board.move(input, firstPlayer)) {
            continue
        }

        board.print()
        firstPlayer = !firstPlayer
    }
}

class Board(private val pawns: ArrayList<ArrayList<String>>) {
    fun move(command: String, firstPlayer: Boolean): Boolean {
        val fromX = command[0].code - 97 // 'a'
        val fromY = command[1].code - 49 // '1'
        val toX = command[2].code - 97
        val toY = command[3].code - 49

        val from = pawns[fromY][fromX]
        if (firstPlayer && from != "W") {
            println("No white pawn at ${command.subSequence(0, 2)}")
            return false
        }
        if (!firstPlayer && from != "B") {
            println("No black pawn at ${command.subSequence(0, 2)}")
            return false
        }

        if (fromX != toX || fromY == toY) {
            println("Invalid Input")
            return false
        }

        val to = pawns[toY][toX]
        if (to != " ") {
            println("Invalid Input")
            return false
        }

        val dist0 = if (firstPlayer) 1 else -1
        val dist1 =
            if (firstPlayer && fromY == 1 || !firstPlayer && fromY == 6) dist0 * 2 else dist0

        if (toY - fromY != dist0 && toY - fromY != dist1) {
            println("Invalid Input")
            return false
        }

        pawns[toY][toX] = from
        pawns[fromY][fromX] = " "
        return true
    }

    fun print() {
        println(
            listOf(
                    "  +---+---+---+---+---+---+---+---+",
                    "8 | ${pawns[7][0]} | ${pawns[7][1]} | ${pawns[7][2]} | ${pawns[7][3]} | ${pawns[7][4]} | ${pawns[7][5]} | ${pawns[7][6]} | ${pawns[7][7]} |",
                    "  +---+---+---+---+---+---+---+---+",
                    "7 | ${pawns[6][0]} | ${pawns[6][1]} | ${pawns[6][2]} | ${pawns[6][3]} | ${pawns[6][4]} | ${pawns[6][5]} | ${pawns[6][6]} | ${pawns[6][7]} |",
                    "  +---+---+---+---+---+---+---+---+",
                    "6 | ${pawns[5][0]} | ${pawns[5][1]} | ${pawns[5][2]} | ${pawns[5][3]} | ${pawns[5][4]} | ${pawns[5][5]} | ${pawns[5][6]} | ${pawns[5][7]} |",
                    "  +---+---+---+---+---+---+---+---+",
                    "5 | ${pawns[4][0]} | ${pawns[4][1]} | ${pawns[4][2]} | ${pawns[4][3]} | ${pawns[4][4]} | ${pawns[4][5]} | ${pawns[4][6]} | ${pawns[4][7]} |",
                    "  +---+---+---+---+---+---+---+---+",
                    "4 | ${pawns[3][0]} | ${pawns[3][1]} | ${pawns[3][2]} | ${pawns[3][3]} | ${pawns[3][4]} | ${pawns[3][5]} | ${pawns[3][6]} | ${pawns[3][7]} |",
                    "  +---+---+---+---+---+---+---+---+",
                    "3 | ${pawns[2][0]} | ${pawns[2][1]} | ${pawns[2][2]} | ${pawns[2][3]} | ${pawns[2][4]} | ${pawns[2][5]} | ${pawns[2][6]} | ${pawns[2][7]} |",
                    "  +---+---+---+---+---+---+---+---+",
                    "2 | ${pawns[1][0]} | ${pawns[1][1]} | ${pawns[1][2]} | ${pawns[1][3]} | ${pawns[1][4]} | ${pawns[1][5]} | ${pawns[1][6]} | ${pawns[1][7]} |",
                    "  +---+---+---+---+---+---+---+---+",
                    "1 | ${pawns[0][0]} | ${pawns[0][1]} | ${pawns[0][2]} | ${pawns[0][3]} | ${pawns[0][4]} | ${pawns[0][5]} | ${pawns[0][6]} | ${pawns[0][7]} |",
                    "  +---+---+---+---+---+---+---+---+",
                    "    a   b   c   d   e   f   g   h",
                    "",
                )
                .joinToString("\n")
        )
    }
}
