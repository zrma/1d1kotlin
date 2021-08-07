fun main() {
    repeat(3) { println("hello") }

    val n = readLine()!!.toInt()
    var sum = 0

    repeat(n) {
        val next = readLine()!!.toInt()
        sum += next
    }
    println(sum)

    val m = readLine()!!.toInt()
    sum = List(m) { readLine()!!.toInt() }.sum()
    println(sum)
}
