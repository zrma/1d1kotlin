package processor

fun main() {
    while (true) {
        println("1. Add matrices")
        println("2. Multiply matrix by a constant")
        println("3. Multiply matrices")
        println("4. Transpose matrix")
        println("5. Calculate a determinant")
//        println("6. Inverse matrix")
        println("0. Exit")
        print("Your choice: ")
        when (readln().toInt()) {
            1 -> addMatrices()
            2 -> multiplyMatrixByConstant()
            3 -> multiplyMatrices()
            4 -> transposeMatrix()
            5 -> calculateDeterminant()
//            6 -> inverseMatrix()
            0 -> return
        }
    }
}

fun addMatrices() {
    val mat0 = newMatrix("first")
    val mat1 = newMatrix("second")

    try {
        val mat2 = mat0 + mat1
        mat2.print()
    } catch (e: Exception) {
        println(e.message)
    }
}

fun multiplyMatrixByConstant() {
    val mat0 = newMatrix()
    val n = readln().toLong()

    try {
        val mat1 = mat0.multiply(n)
        mat1.print()
    } catch (e: Exception) {
        println(e.message)
    }
}

fun multiplyMatrices() {
    val mat0 = newMatrix("first")
    val mat1 = newMatrix("second")

    try {
        val mat2 = mat0 * mat1
        mat2.print()
    } catch (e: Exception) {
        println(e.message)
    }
}

fun transposeMatrix() {
    println("1. Main diagonal")
    println("2. Side diagonal")
    println("3. Vertical line")
    println("4. Horizontal line")
    print("Your choice: ")
    val chosen = readln().toInt()
    val mat0 = newMatrix()
    val mat1 = when (chosen) {
        1 -> mat0.transposeMainDiagonal()
        2 -> mat0.transposeSideDiagonal()
        3 -> mat0.transposeVerticalLine()
        4 -> mat0.transposeHorizontalLine()
        else -> throw Exception("Invalid choice")
    }
    mat1.print()
}

fun calculateDeterminant() {
    val mat0 = newMatrix()
    val det = mat0.determinant()
    println("The result is:")
    println(det)
}

fun newMatrix(seq: String = ""): Matrix {
    if (seq.isNotEmpty()) {
        print("Enter size of $seq matrix: ")
    } else {
        print("Enter size of matrix: ")
    }
    val (n, m) = readln().split(" ").map { it.toInt() }

    if (seq.isNotEmpty()) {
        println("Enter $seq matrix:")
    } else {
        println("Enter matrix:")
    }
    val mat = Matrix(n, m)
    for (i in 0 until n) {
        mat.setRow(i, readln().split(" ").map { it.toDouble() }.toDoubleArray())
    }
    return mat
}

class Matrix(private val rows: Int, private val columns: Int) {
    private val matrix = Array(rows) { DoubleArray(columns) }

    fun get(row: Int, column: Int) = matrix[row][column]

    fun set(row: Int, column: Int, value: Double) {
        matrix[row][column] = value
    }

    fun setRow(row: Int, values: DoubleArray) {
        matrix[row] = values
    }

    fun print() {
        matrix.forEach { row ->
            row.forEach { print("$it ") }
            println()
        }
        println()
    }

    operator fun plus(other: Matrix): Matrix {
        if (rows != other.rows || columns != other.columns) {
            throw IllegalArgumentException("The operation cannot be performed.")
        }
        val result = Matrix(rows, columns)
        for (i in 0 until rows) {
            for (j in 0 until columns) {
                result.set(i, j, get(i, j) + other.get(i, j))
            }
        }
        return result
    }

    operator fun times(other: Matrix): Matrix {
        if (columns != other.rows) {
            throw IllegalArgumentException("The operation cannot be performed.")
        }
        val result = Matrix(rows, other.columns)
        for (i in 0 until rows) {
            for (j in 0 until other.columns) {
                for (k in 0 until columns) {
                    result.set(i, j, result.get(i, j) + get(i, k) * other.get(k, j))
                }
            }
        }
        return result
    }

    fun multiply(n: Long): Matrix {
        val result = Matrix(rows, columns)
        for (i in 0 until rows) {
            for (j in 0 until columns) {
                result.set(i, j, get(i, j) * n)
            }
        }
        return result
    }

    fun transposeMainDiagonal(): Matrix {
        val result = Matrix(columns, rows)
        for (i in 0 until rows) {
            for (j in 0 until columns) {
                result.set(j, i, get(i, j))
            }
        }
        return result
    }

    fun transposeSideDiagonal(): Matrix {
        val result = Matrix(columns, rows)
        for (i in 0 until rows) {
            for (j in 0 until columns) {
                result.set(columns - j - 1, rows - i - 1, get(i, j))
            }
        }
        return result
    }

    fun transposeVerticalLine(): Matrix {
        val result = Matrix(rows, columns)
        for (i in 0 until rows) {
            for (j in 0 until columns) {
                result.set(i, columns - j - 1, get(i, j))
            }
        }
        return result
    }

    fun transposeHorizontalLine(): Matrix {
        val result = Matrix(rows, columns)
        for (i in 0 until rows) {
            for (j in 0 until columns) {
                result.set(rows - i - 1, j, get(i, j))
            }
        }
        return result
    }

    fun determinant(): Double {
        if (rows != columns) {
            throw IllegalArgumentException("The operation cannot be performed.")
        }
        if (rows == 1) {
            return get(0, 0)
        }
        var det = 0.0
        for (i in 0 until columns) {
            det += get(0, i) * cofactor(0, i)
        }
        return det
    }

    private fun cofactor(row: Int, col: Int): Double {
        val minor = Matrix(rows - 1, columns - 1)
        var r = 0
        for (i in 0 until rows) {
            if (i == row) {
                continue
            }
            var c = 0
            for (j in 0 until columns) {
                if (j == col) {
                    continue
                }
                minor.set(r, c, get(i, j))
                c++
            }
            r++
        }
        return minor.determinant() * if ((row + col) % 2 == 0) 1 else -1
    }
}
