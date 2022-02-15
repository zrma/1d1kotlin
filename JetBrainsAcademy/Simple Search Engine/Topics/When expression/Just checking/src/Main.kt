fun main() {
    println(
        when (readLine()!!.toInt()) {
            2 -> "Yes!"
            in 1..4 -> "No!"
            else -> "Unknown number"
        }
    )
}
