package minesweeper

import kotlin.random.Random

const val MINE = "X"
const val CELL = "."
const val SIZE = 9

fun main() {
    val board = newBoard()
    printBoard(board)
}

class Cell(val data: String)

fun newBoard(): Array<Array<Cell>> {
    val board = Array(SIZE) { Array(SIZE) { Cell(CELL) } }
    initMines(board)
    initCounts(board)

    return board
}

fun initMines(board: Array<Array<Cell>>) {
    println("How many mines do you want on the field?")
    val mineCount = readLine()!!.toInt()

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
}

fun initCounts(board: Array<Array<Cell>>) {
    for (x in 0 until SIZE) {
        for (y in 0 until SIZE) {
            if (board[x][y].data == CELL) {
                val count = countMines(board, x, y)
                if (count > 0) {
                    board[x][y] = Cell(count.toString())
                }
            }
        }
    }
}

fun countMines(board: Array<Array<Cell>>, x: Int, y: Int): Int {
    var count = 0
    for (i in x - 1..x + 1) {
        for (j in y - 1..y + 1) {
            if (i in 0 until SIZE && j in 0 until SIZE) {
                if (board[i][j].data == MINE) {
                    count++
                }
            }
        }
    }
    return count
}

fun printBoard(board: Array<Array<Cell>>) {
    board.forEach { row ->
        row.forEach { col -> print(col.data) }
        println()
    }
}
