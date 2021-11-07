fun main() {
    val arg1 = readLine()!!
    val op = readLine()!!
    val arg2 = readLine()!!

    println(
        when (op) {
            "equals" -> arg1 == arg2
            "plus" -> arg1 + arg2
            "endsWith" -> arg1.endsWith(arg2)
            else -> "Unknown operation"
        }
    )
}
