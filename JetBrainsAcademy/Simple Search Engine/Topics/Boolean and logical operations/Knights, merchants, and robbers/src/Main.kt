fun main() {
    val (firstAnswer, secondAnswer, confessor) = List(3) { readLine()!!.toBoolean() }
    println(firstAnswer == secondAnswer && !confessor)
}
