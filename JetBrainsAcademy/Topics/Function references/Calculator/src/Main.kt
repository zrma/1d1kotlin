fun add(x: Int, y: Int) = x + y

fun subtract(x: Int, y: Int) = x - y

fun divide(x: Int, y: Int) = x / y

fun multiply(x: Int, y: Int) = x * y

fun calculate(x: Int, y: Int, operator: (Int, Int) -> Int) {
    // write your code here
    val result = operator(x, y)
    print(result)
}

fun main() {
    val x: Int = readLine()!!.toInt()
    val y: Int = readLine()!!.toInt()
    val operator: String = readLine()!!
    when (operator) {
        // write your code here
        "add" -> calculate(x, y, ::add)
        "subtract" -> calculate(x, y, ::subtract)
        "multiply" -> calculate(x, y, ::multiply)
        "divide" -> calculate(x, y, ::divide)
    }
}