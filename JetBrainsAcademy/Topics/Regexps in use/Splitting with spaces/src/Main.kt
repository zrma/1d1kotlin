fun main() {
    val string = readLine()!!
    val n = readLine()!!.toInt()

    string.split(Regex(" +"), n).forEach(::println)
}
