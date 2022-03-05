package minesweeper

import kotlin.random.Random

const val MINE = "X"
const val CELL = "."
const val SIZE = 9
const val MARK = "*"

fun main() {
    val board = newBoard()

    while (true) {
        printField(board)

        if (checkWin(board)) {
            println("Congratulations! You found all the mines!")
            break
        }

        print("Set/delete mines marks (x and y coordinates):")
        val (x, y) = readLine()!!.split(" ").map { it.toInt() }

        val target = board[y - 1][x - 1].data
        if (target.toIntOrNull() != null) {
            println("There is a number here!")
            continue
        }

        board[y - 1][x - 1].marked = !board[y - 1][x - 1].marked
    }
}

class Cell(val data: String, var marked: Boolean = false)

fun newBoard(): Array<Array<Cell>> {
    val board = Array(SIZE) { Array(SIZE) { Cell(CELL) } }
    initMines(board)
    initCounts(board)

    return board
}

fun initMines(board: Array<Array<Cell>>) {
    print("How many mines do you want on the field?")
    val mineCount = readLine()!!.toInt()

    val random = Random.Default

    var count = 0
    while (count < mineCount) {
        val x = random.nextInt(0, SIZE)
        val y = random.nextInt(0, SIZE)
        if (board[y][x].data == CELL) {
            board[y][x] = Cell(MINE)
            count++
        }
    }
}

fun initCounts(board: Array<Array<Cell>>) {
    for (y in 0 until SIZE) {
        for (x in 0 until SIZE) {
            if (board[y][x].data == CELL) {
                val count = countMines(board, x, y)
                if (count > 0) {
                    board[y][x] = Cell(count.toString())
                }
            }
        }
    }
}

fun countMines(board: Array<Array<Cell>>, x: Int, y: Int): Int {
    var count = 0
    for (i in y - 1..y + 1) {
        for (j in x - 1..x + 1) {
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

fun printField(board: Array<Array<Cell>>) {
    println(" │123456789│")
    println("—│—————————│")
    for (y in 0 until SIZE) {
        print("${y + 1}│")
        for (x in 0 until SIZE) {
            val cur = board[y][x]

            if (cur.marked) {
                print(MARK)
                continue
            }

            if (cur.data.toIntOrNull() != null) {
                print(cur.data)
            } else {
                print(CELL)
            }
        }
        println("│")
    }
    println("—│—————————│")
}

fun checkWin(board: Array<Array<Cell>>): Boolean {
    for (y in 0 until SIZE) {
        for (x in 0 until SIZE) {
            val cur = board[y][x]

            if (cur.data == MINE && !cur.marked || cur.data != MINE && cur.marked) {
                return false
            }
        }
    }
    return true
}
