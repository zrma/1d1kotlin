fun main() {
    val year = readLine()!!.toInt()
    println(if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) "Leap" else "Regular")
}
