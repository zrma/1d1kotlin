fun multiplyByTwo(number: Int): Int {
    return number * 2
}

fun addTen(number: Int): Int {
    return number + 10
}

fun changeNumber(changeFunction: (Int) -> Int, number: Int) {
    val newNumber = changeFunction(number)
    print("$newNumber ")
}

fun main() {
    val numbers = readLine()!!.split(' ').map { it.toInt() }.toList()
    var numberFun: (Int) -> Int
    for (number in numbers) {
        numberFun = if (number % 2 == 0) ::addTen else ::multiplyByTwo

        changeNumber(numberFun, number)
    }
}