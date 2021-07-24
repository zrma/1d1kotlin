fun main() {
    val numbers = readLine()!!.split(' ').map { it.toInt() }.toIntArray()
    // Do not touch lines above

    numbers[0] = numbers.last().also { numbers[numbers.lastIndex] = numbers.first() }

    // Do not touch lines below
    println(numbers.joinToString(separator = " "))
}
