fun main() {
    val celsius = readLine()!!.toFloat()
    val fahrenheit = celsius * 1.8 + 32
    println(String.format("%.2f", fahrenheit))
}
