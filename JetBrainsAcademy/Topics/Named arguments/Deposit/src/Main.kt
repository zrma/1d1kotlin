fun main() {
    val param = readLine()

    println(
        when (param) {
            "amount" -> calcFinalAmount(startingAmount = readLine()!!.toDouble())
            "percent" -> calcFinalAmount(yearlyPercent = readLine()!!.toDouble())
            else -> calcFinalAmount(years = readLine()!!.toDouble())
        }
    )
}

fun calcFinalAmount(
    startingAmount: Double = 1000.0,
    yearlyPercent: Double = 5.0,
    years: Double = 10.0
): Int {
    return (startingAmount * Math.pow(1 + yearlyPercent / 100, years)).toInt()
}
