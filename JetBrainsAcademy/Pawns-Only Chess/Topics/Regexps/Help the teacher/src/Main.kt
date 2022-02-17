fun main() {
    val report = readLine()!!
    // write your code here.

    println(Regex("^[0-9] wrong answers?").matches(report))
}
