fun main() {
    val input = readLine()!!.single()
    val result = input.isUpperCase() || input in '1'..'9'
    println(result)
}
