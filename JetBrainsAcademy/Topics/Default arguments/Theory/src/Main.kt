fun main(args: Array<String>) {
    printLine("Hello, Kotlin", "!!!") // prints "Hello, Kotlin!!!"
    printLine("Kotlin") // prints "Kotlin" with an ending
    printLine() // prints an empty line like println()

    println(findMax(11, 15)) // 15
    println(findMax(11, 15, true)) // 15
    println(findMax(-4, -9)) // -4
    println(findMax(-4, -9, true)) // -9
}

fun printLine(line: String = "", end: String = "\n") = print("$line$end")

fun findMax(n1: Int, n2: Int, absolute: Boolean = false): Int {
    val v1: Int
    val v2: Int

    if (absolute) {
        v1 = Math.abs(n1)
        v2 = Math.abs(n2)
    } else {
        v1 = n1
        v2 = n2
    }

    return if (v1 > v2) n1 else n2
}
