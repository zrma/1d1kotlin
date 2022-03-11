fun main() {
    println(calculateSpentMoneyUnsafe(0, 1))
    println(calculateSpentMoneyUnsafe(0, 0))
    println(calculateSpentMoneyUnsafe(-1, 1))

    println(calculateSpentMoneyDivByZeroGuard(0, 1))
    println(calculateSpentMoneyDivByZeroGuard(0, 0))
    println(calculateSpentMoneyDivByZeroGuard(-1, 1))

    println(calculateSpentMoneyWithException(0, 1))
    println(calculateSpentMoneyWithException(0, 0))
    println(calculateSpentMoneyWithException(-1, 1))
}

fun calculateSpentMoneyUnsafe(total: Int, itemPrice: Int): Int {
    val amountToBuy = total / itemPrice
    return amountToBuy * itemPrice
}

fun calculateSpentMoneyDivByZeroGuard(total: Int, itemPrice: Int): Int {
    if (itemPrice == 0) {
        return 0
    }
    val amountToBuy = total / itemPrice
    return amountToBuy * itemPrice
}

fun calculateSpentMoneyWithException(total: Int, itemPrice: Int): Int {
    if (total < 0) {
        throw Exception("Total can't be negative")
    }
    if (itemPrice < 0) {
        throw Exception("Item price can't be negative")
    }
    if (itemPrice == 0) {
        return 0
    }
    val amountToBuy = total / itemPrice
    return amountToBuy * itemPrice
}
