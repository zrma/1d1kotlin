fun main() {
    val grades = IntArray(4)
    repeat(readLine()!!.toInt()) { grades[readLine()!!.toInt() - 2]++ }
    println(grades.joinToString(" "))
}
