fun main() {
    val numOfCompanies = readLine()!!.toInt()
    val incomes = IntArray(numOfCompanies)
    for (i in 0 until numOfCompanies) {
        incomes[i] = readLine()!!.toInt()
    }
    val taxes = IntArray(numOfCompanies)
    for (i in 0 until numOfCompanies) {
        taxes[i] = readLine()!!.toInt()
    }
    val highestTax = incomes.zip(taxes).withIndex().maxByOrNull { it.value.first * it.value.second }!!.index
    println(highestTax + 1)
}