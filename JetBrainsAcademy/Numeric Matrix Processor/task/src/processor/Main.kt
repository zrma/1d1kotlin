package processor

fun main() {
    val mat0 = newMatrix()
    val mat1 = newMatrix()

    try {
        val mat2 = mat0 + mat1
        mat2.print()
    } catch (e: Exception) {
        println(e.message)
    }
}

fun newMatrix(): Matrix {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val mat = Matrix(n, m)
    for (i in 0 until n) {
        mat.setRow(i, readLine()!!.split(" ").map { it.toLong() }.toLongArray())
    }
    return mat
}

class Matrix(private val rows: Int, private val columns: Int) {
    private val matrix = Array(rows) { LongArray(columns) }

    fun get(row: Int, column: Int) = matrix[row][column]

    fun set(row: Int, column: Int, value: Long) {
        matrix[row][column] = value
    }

    fun setRow(row: Int, values: LongArray) {
        matrix[row] = values
    }

    fun print() {
        matrix.forEach { row ->
            row.forEach { print("$it ") }
            println()
        }
    }

    operator fun plus(other: Matrix): Matrix {
        if (rows != other.rows || columns != other.columns) {
            throw IllegalArgumentException("ERROR")
        }
        val result = Matrix(rows, columns)
        for (i in 0 until rows) {
            for (j in 0 until columns) {
                result.set(i, j, get(i, j) + other.get(i, j))
            }
        }
        return result
    }
}
