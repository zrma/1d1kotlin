fun main() {
    val str = readLine()!!
    val nth = readLine()!!.toInt()
    val idx = nth - 1
    println("""Symbol # $nth of the string "$str" is '${str[idx]}'""")
}
