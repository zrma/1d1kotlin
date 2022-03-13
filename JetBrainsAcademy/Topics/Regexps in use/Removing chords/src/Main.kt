fun main() {
    val text = readLine()!!

    val regex = Regex("(Am?|Em?|Dm?|G|C) ")
    println(text.replace(regex, ""))
}
