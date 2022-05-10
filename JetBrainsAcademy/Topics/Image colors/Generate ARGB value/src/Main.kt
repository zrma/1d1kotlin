fun printARGB() {
    val input = readLine()!!.split(" ").map { it.toInt() }
    val (a, r, g, b) = input

    if (input.all { it in 0..255 }) {
        println(Color(r, g, b, a).rgb.toUInt())
    } else {
        println("Invalid input")
    }
}
