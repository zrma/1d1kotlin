package minesweeper

import kotlin.random.Random

const val UNEXPLORED = "."
const val MINE = "X"
const val SIZE = 9
const val MARKED = "*"
const val FREE = "/"

fun main() {
    val board = newBoard()

    while (true) {
        printField(board, false)

        if (checkWin(board)) {
            println("Congratulations! You found all the mines!")
            break
        }

        val (x, y, opt) = inputData()
        val target = board[y - 1][x - 1]

        when (opt) {
            "free" -> {
                if (target.isMine()) {
                    printField(board, true)
                    println("You stepped on a mine and failed!")
                    break
                }

                checkNeighbors(board, x - 1, y - 1)
            }
            else -> {
                if (target.checked && target.isDigit()) {
                    println("There is a number here!")
                    continue
                }

                board[y - 1][x - 1].marked = !board[y - 1][x - 1].marked
            }
        }
    }
}

fun inputData(): Triple<Int, Int, String> {
    print("Set/unset mines marks or claim a cell as free:")
    val (x, y, opt) = readLine()!!.split(" ")
    return Triple(x.toInt(), y.toInt(), opt)
}

fun checkNeighbors(board: Array<Array<Cell>>, startX: Int, startY: Int) {
    val queue = ArrayList<Pair<Int, Int>>()
    queue.add(Pair(startX, startY))

    while (queue.isNotEmpty()) {
        val (x, y) = queue.removeAt(0)
        val target = board[y][x]
        target.checked = true
        target.marked = false

        if (target.isDigit()) {
            continue
        }

        for (i in y - 1..y + 1) {
            for (j in x - 1..x + 1) {
                if (i in 0 until SIZE && j in 0 until SIZE) {
                    if (!board[i][j].checked) {
                        queue.add(Pair(j, i))
                    }
                }
            }
        }
    }
}

class Cell(val data: String, var marked: Boolean = false, var checked: Boolean = false) {
    fun isMine() = data == MINE
    fun isDigit() = data.toIntOrNull() != null
}

fun newBoard(): Array<Array<Cell>> {
    val board = Array(SIZE) { Array(SIZE) { Cell(FREE) } }
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
        if (board[y][x].data == FREE) {
            board[y][x] = Cell(MINE)
            count++
        }
    }
}

fun initCounts(board: Array<Array<Cell>>) {
    for (y in 0 until SIZE) {
        for (x in 0 until SIZE) {
            if (board[y][x].data == FREE) {
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

fun printField(board: Array<Array<Cell>>, gameOver: Boolean) {
    println(" │123456789│")
    println("—│—————————│")
    for (y in 0 until SIZE) {
        print("${y + 1}│")
        for (x in 0 until SIZE) {
            val cur = board[y][x]

            if (gameOver && cur.data == MINE) {
                print(MINE)
                continue
            }

            if (cur.marked) {
                print(MARKED)
                continue
            }

            if (cur.checked) {
                print(cur.data)
                continue
            }

            print(UNEXPLORED)
        }
        println("│")
    }
    println("—│—————————│")
}

fun checkWin(board: Array<Array<Cell>>): Boolean {
    if (isCheckedAllMines(board) || isCheckedAllFree(board)) {
        return true
    }
    return false
}

fun isCheckedAllMines(board: Array<Array<Cell>>): Boolean {
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

fun isCheckedAllFree(board: Array<Array<Cell>>): Boolean {
    for (y in 0 until SIZE) {
        for (x in 0 until SIZE) {
            val cur = board[y][x]

            if (cur.data != MINE && !cur.checked) {
                return false
            }
        }
    }
    return true
}
