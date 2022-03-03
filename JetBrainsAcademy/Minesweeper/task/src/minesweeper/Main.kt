package minesweeper

import kotlin.random.Random

const val MINE = "X"
const val CELL = "."
const val SIZE = 9

fun main() {
    println("How many mines do you want on the field?")
    val board = newBoard(readLine()!!.toInt())
    printBoard(board)
}

class Cell(val data: String)

fun newBoard(mineCount: Int): Array<Array<Cell>> {
    val board = Array(SIZE) { Array(SIZE) { Cell(CELL) } }

    val random = Random.Default

    var count = 0
    while (count < mineCount) {
        val x = random.nextInt(0, SIZE)
        val y = random.nextInt(0, SIZE)
        if (board[x][y].data == CELL) {
            board[x][y] = Cell(MINE)
            count++
        }
    }
    return board
}

fun printBoard(board: Array<Array<Cell>>) {
    board.forEach { row ->
        row.forEach { col -> print(col.data) }
        println()
    }
}
