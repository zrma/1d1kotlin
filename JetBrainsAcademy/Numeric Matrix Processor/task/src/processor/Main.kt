package processor

fun main() {
    while (true) {
        println("1. Add matrices")
        println("2. Multiply matrix by a constant")
        println("3. Multiply matrices")
//        println("4. Transpose matrix")
//        println("5. Calculate a determinant")
//        println("6. Inverse matrix")
        println("0. Exit")
        print("Your choice: ")
        when (readln().toInt()) {
            1 -> addMatrices()
            2 -> multiplyMatrixByConstant()
            3 -> multiplyMatrices()
//            4 -> transposeMatrix()
//            5 -> calculateDeterminant()
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
}
