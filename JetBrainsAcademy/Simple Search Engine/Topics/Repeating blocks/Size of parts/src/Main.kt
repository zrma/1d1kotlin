fun main() {
    val n = readLine()!!.toInt()
    var larger = 0
    var smaller = 0
    var perfect = 0
    repeat(n) {
        when (readLine()!!.toInt()) {
            1 -> ++larger
            0 -> ++perfect
            -1 -> ++smaller
        }
    }
    println("$perfect $larger $smaller")
}
