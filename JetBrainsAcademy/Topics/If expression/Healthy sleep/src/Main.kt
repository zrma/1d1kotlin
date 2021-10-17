fun main() {
    val a = readLine()!!.toInt()
    val b = readLine()!!.toInt()
    val h = readLine()!!.toInt()

    if (h < a) {
        println("Deficiency")
    } else if (b < h) {
        println("Excess")
    } else {
        println("Normal")
    }
}
