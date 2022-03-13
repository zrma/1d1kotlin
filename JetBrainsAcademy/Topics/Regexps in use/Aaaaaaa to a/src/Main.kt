fun main() {
    val text = readLine()!!
    val pattern = Regex("(a|A)+")
    val result = text.replace(pattern, "a")
    println(result)
}
