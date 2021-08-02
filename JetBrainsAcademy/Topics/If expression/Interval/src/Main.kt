fun main() {
    val num = readLine()!!.toInt()
    if (num in -14..12 || (num in 15..16) || num >= 19) {
        println("True")
    } else {
        println("False")
    }
}
