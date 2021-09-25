fun main() {
    val count = readLine()!!.toInt()
    val incomes = List(count) { readLine()!!.toInt() }
    val taxes = List(count) { readLine()!!.toInt() }

    println(
        incomes.zip(taxes).map { it.first * it.second }.withIndex().maxByOrNull { it.value }!!
            .index + 1
    )
}
