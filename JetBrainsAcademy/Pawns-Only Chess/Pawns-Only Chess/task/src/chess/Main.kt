package chess

fun main() {
    val title = "Pawns-Only Chess"
    println(title)

    println("First Player's name:")
    val player0 = readLine()!!
    println("Second Player's name:")
    val player1 = readLine()!!

    val board =
        listOf(
            "  +---+---+---+---+---+---+---+---+",
            "8 |   |   |   |   |   |   |   |   |",
            "  +---+---+---+---+---+---+---+---+",
            "7 | B | B | B | B | B | B | B | B |",
            "  +---+---+---+---+---+---+---+---+",
            "6 |   |   |   |   |   |   |   |   |",
            "  +---+---+---+---+---+---+---+---+",
            "5 |   |   |   |   |   |   |   |   |",
            "  +---+---+---+---+---+---+---+---+",
            "4 |   |   |   |   |   |   |   |   |",
            "  +---+---+---+---+---+---+---+---+",
            "3 |   |   |   |   |   |   |   |   |",
            "  +---+---+---+---+---+---+---+---+",
            "2 | W | W | W | W | W | W | W | W |",
            "  +---+---+---+---+---+---+---+---+",
            "1 |   |   |   |   |   |   |   |   |",
            "  +---+---+---+---+---+---+---+---+",
            "    a   b   c   d   e   f   g   h",
        )
    println(board.joinToString("\n"))

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

        firstPlayer = !firstPlayer
    }
}
