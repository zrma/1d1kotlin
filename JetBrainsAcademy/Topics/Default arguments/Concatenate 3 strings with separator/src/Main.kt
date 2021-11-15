fun main() {
    val s0 = readLine()!!
    val s1 = readLine()!!
    val s2 = readLine()!!
    val separator = readLine()!!
    println(
        if (separator == "NO SEPARATOR") {
            concatenates(s0, s1, s2)
        } else {
            concatenates(s0, s1, s2, separator)
        }
    )
}

fun concatenates(s0: String, s1: String, s3: String, separator: String = " "): String {
    return "$s0$separator$s1$separator$s3"
}
