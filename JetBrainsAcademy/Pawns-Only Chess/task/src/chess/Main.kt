package chess

import kotlin.math.abs

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
                arrayListOf(Cell(" "), Cell(" "), Cell(" "), Cell(" "), Cell(" "), Cell(" "), Cell(" "), Cell(" ")),
                arrayListOf(Cell("W"), Cell("W"), Cell("W"), Cell("W"), Cell("W"), Cell("W"), Cell("W"), Cell("W")),
                arrayListOf(Cell(" "), Cell(" "), Cell(" "), Cell(" "), Cell(" "), Cell(" "), Cell(" "), Cell(" ")),
                arrayListOf(Cell(" "), Cell(" "), Cell(" "), Cell(" "), Cell(" "), Cell(" "), Cell(" "), Cell(" ")),
                arrayListOf(Cell(" "), Cell(" "), Cell(" "), Cell(" "), Cell(" "), Cell(" "), Cell(" "), Cell(" ")),
                arrayListOf(Cell(" "), Cell(" "), Cell(" "), Cell(" "), Cell(" "), Cell(" "), Cell(" "), Cell(" ")),
                arrayListOf(Cell("B"), Cell("B"), Cell("B"), Cell("B"), Cell("B"), Cell("B"), Cell("B"), Cell("B")),
                arrayListOf(Cell(" "), Cell(" "), Cell(" "), Cell(" "), Cell(" "), Cell(" "), Cell(" "), Cell(" ")),
            )
        )
    board.print()

    var turn = 0
    while (true) {
        val firstPlayer = turn % 2 == 0
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
        if (!board.move(input, turn)) {
            continue
        }

        board.print()
        ++turn
    }
}

class Board(private val pawns: ArrayList<ArrayList<Cell>>) {
    fun move(command: String, turn: Int): Boolean {
        val fromX = command[0].code - 97 // 'a'
        val fromY = command[1].code - 49 // '1'
        val toX = command[2].code - 97
        val toY = command[3].code - 49

        val from = pawns[fromY][fromX]
        val to = pawns[toY][toX]

        val opt = CommandOpt(
            command,
            fromX,
            fromY,
            from,
            toX,
            toY,
            to,
            turn,
            firstPlayer = turn % 2 == 0
        )

        if (!exist(opt)) {
            return false
        }

        if (!checkY(opt)) {
            return false
        }

        if (abs(toX - fromX) == 1) {
            return capture(opt)
        }

        if (toX != fromX) {
            println("Invalid Input")
            return false
        }

        if (to.color != " ") {
            println("Invalid Input")
            return false
        }

        pawns[toY][toX] = Cell(from.color, turn)
        pawns[fromY][fromX] = Cell(" ")
        return true
    }

    private fun capture(opt: CommandOpt): Boolean {
        val firstPlayer = opt.firstPlayer
        val from = opt.from
        val fromX = opt.fromX
        val fromY = opt.fromY
        val toX = opt.toX
        val toY = opt.toY
        val turn = opt.turn

        val dist = if (firstPlayer) 1 else -1
        if (toY - fromY != dist) {
            println("Invalid Input")
            return false
        }

        val enemy = if (firstPlayer) "B" else "W"
        val to = pawns[toY][toX]
        if (to.color == enemy) {
            pawns[toY][toX] = Cell(from.color, turn)
            pawns[fromY][fromX] = Cell(" ")
            return true
        }
        val guardTarget = pawns[toY - dist][toX]
        if (guardTarget.color == enemy && guardTarget.turn == turn - 1) {
            pawns[toY][toX] = Cell(from.color, turn)
            pawns[fromY][fromX] = Cell(" ")
            pawns[toY - dist][toX] = Cell(" ")
            return true
        }
        println("Invalid Input")
        return false
    }

    companion object {
        fun exist(opt: CommandOpt): Boolean {
            val firstPlayer = opt.firstPlayer
            val from = opt.from
            val command = opt.command

            if (firstPlayer && from.color != "W") {
                println("No white pawn at ${command.subSequence(0, 2)}")
                return false
            }
            if (!firstPlayer && from.color != "B") {
                println("No black pawn at ${command.subSequence(0, 2)}")
                return false
            }
            return true
        }

        fun checkY(opt: CommandOpt): Boolean {
            val firstPlayer = opt.firstPlayer
            val fromY = opt.fromY
            val toY = opt.toY

            val dist0 = if (firstPlayer) 1 else -1
            val dist1 =
                if (firstPlayer && fromY == 1 || !firstPlayer && fromY == 6) dist0 * 2 else dist0

            if (toY - fromY != dist0 && toY - fromY != dist1) {
                println("Invalid Input")
                return false
            }
            return true
        }
    }

    fun print() {
        println(
            listOf(
                "  +---+---+---+---+---+---+---+---+",
                "8 | ${pawns[7].joinToString(" | ") { it.color }} |",
                "  +---+---+---+---+---+---+---+---+",
                "7 | ${pawns[6].joinToString(" | ") { it.color }} |",
                "  +---+---+---+---+---+---+---+---+",
                "6 | ${pawns[5].joinToString(" | ") { it.color }} |",
                "  +---+---+---+---+---+---+---+---+",
                "5 | ${pawns[4].joinToString(" | ") { it.color }} |",
                "  +---+---+---+---+---+---+---+---+",
                "4 | ${pawns[3].joinToString(" | ") { it.color }} |",
                "  +---+---+---+---+---+---+---+---+",
                "3 | ${pawns[2].joinToString(" | ") { it.color }} |",
                "  +---+---+---+---+---+---+---+---+",
                "2 | ${pawns[1].joinToString(" | ") { it.color }} |",
                "  +---+---+---+---+---+---+---+---+",
                "1 | ${pawns[0].joinToString(" | ") { it.color }} |",
                "  +---+---+---+---+---+---+---+---+",
                "    a   b   c   d   e   f   g   h",
                "",
            )
                .joinToString("\n")
        )
    }
}

data class Cell(val color: String, var turn: Int = 0)

data class CommandOpt(
    val command: String,
    val fromX: Int,
    val fromY: Int,
    val from: Cell,
    val toX: Int,
    val toY: Int,
    val to: Cell,
    val turn: Int,
    val firstPlayer: Boolean
)