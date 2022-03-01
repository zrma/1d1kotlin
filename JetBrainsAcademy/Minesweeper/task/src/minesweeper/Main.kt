package minesweeper

const val MINE = "X"
const val CELL = "."

fun main() {
    val board = newBoard(
        arrayOf(
            arrayOf(CELL, CELL, CELL, CELL, CELL, MINE, CELL, CELL, CELL),
            arrayOf(CELL, CELL, CELL, CELL, CELL, CELL, MINE, CELL, CELL),
            arrayOf(CELL, CELL, MINE, CELL, CELL, CELL, CELL, CELL, MINE),
            arrayOf(CELL, CELL, CELL, MINE, CELL, CELL, CELL, CELL, CELL),
            arrayOf(CELL, CELL, CELL, CELL, MINE, CELL, CELL, MINE, CELL),
            arrayOf(CELL, CELL, CELL, CELL, CELL, CELL, CELL, CELL, CELL),
            arrayOf(CELL, CELL, CELL, CELL, CELL, CELL, CELL, CELL, CELL),
            arrayOf(MINE, CELL, CELL, CELL, CELL, CELL, MINE, CELL, CELL),
            arrayOf(CELL, MINE, CELL, CELL, CELL, CELL, CELL, CELL, CELL),
        )
    )
    printBoard(board)
}

class Cell(val data: String) {}

fun newBoard(input: Array<Array<String>>): Array<Array<Cell>> {
    return input.map { row -> row.map { col -> Cell(col) }.toTypedArray() }.toTypedArray()
}

fun printBoard(board: Array<Array<Cell>>) {
    board.forEach { row ->
        row.forEach { col ->
            print(col.data)
        }
        println()
    }
}