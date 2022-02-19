fun main() {
    val (from, to) = List(2) { readLine()!!.toInt() }
    (from..to).forEach {
        when {
            it % 15 == 0 -> println("FizzBuzz")
            it % 3 == 0 -> println("Fizz")
            it % 5 == 0 -> println("Buzz")
            else -> println(it)
        }
    }
}
