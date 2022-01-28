fun main() {
    println(readLine()!!.groupingBy { it }.eachCount().filter { it.value == 1 }.count())
}
