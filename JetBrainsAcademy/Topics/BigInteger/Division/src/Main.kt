fun main() {
    val a = readLine()!!.toBigInteger()
    val b = readLine()!!.toBigInteger()

    val q = a / b
    val r = a % b
    println("$a = $b * $q + $r")
}
