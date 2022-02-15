fun main() {
    val input = readLine()!!
    val res = input.getOrElse(input.lastIndex - 1) { '0' }
    println(res)
}
