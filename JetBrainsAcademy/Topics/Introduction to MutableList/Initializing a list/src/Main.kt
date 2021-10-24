const val TOTAL_LENGTH = 100
const val VALUE_INIT = 0

const val INDEX_FIRST = 0
const val VALUE_FIRST = 1

const val INDEX_TENTH = 9
const val VALUE_TENTH = 10

const val VALUE_LAST = 100

fun main() {
    val numbers = MutableList(TOTAL_LENGTH) { VALUE_INIT }
    numbers[INDEX_FIRST] = VALUE_FIRST
    numbers[INDEX_TENTH] = VALUE_TENTH
    numbers[numbers.lastIndex] = VALUE_LAST

    // do not touch the lines below
    println(numbers.joinToString())
}
