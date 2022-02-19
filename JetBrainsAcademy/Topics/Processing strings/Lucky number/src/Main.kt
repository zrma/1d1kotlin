fun main() {
    val input = readLine()!!
    val sum0 = input.subSequence(0, input.length / 2).map { it.digitToInt() }.sum()
    val sum1 = input.subSequence(input.length / 2, input.length).map { it.digitToInt() }.sum()

    println(
        when (sum0 == sum1) {
            true -> "YES"
            false -> "NO"
        }
    )
}
