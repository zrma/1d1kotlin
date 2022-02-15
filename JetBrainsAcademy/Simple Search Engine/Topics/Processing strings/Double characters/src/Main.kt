fun main() {
    readLine()!!.map { "$it$it" }.joinToString("").let { println(it) }
}
