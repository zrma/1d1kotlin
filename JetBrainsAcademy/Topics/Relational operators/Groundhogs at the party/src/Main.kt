fun main() {
    val peanutButterCups = readLine()!!.toInt()
    val weekend = readLine()!!.toBoolean()
    var result = peanutButterCups in 10..20
    if (weekend) {
        result = peanutButterCups in 15..25
    }
    println(result)
}
