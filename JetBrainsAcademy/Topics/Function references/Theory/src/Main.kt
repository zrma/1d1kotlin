fun main() {
    val numbers = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val oddFunction = ::isOdd
    print("Odd numbers: ")
    printNumbers(numbers, oddFunction)
    print("\nEven numbers: ")
    printNumbers(numbers, ::isEven)

    val person = Person("Sara", "Rogers")
    val personFun: () -> String = person::printFullName

    print(personFun.invoke())
    print(personFun())

    val dec: (Int) -> Int = Int::dec
    print(dec(4)) // 3

    val dec2: (Int) -> Int = { x -> x.dec() }
    print(dec2(4)) // 3

    val operatorMultiply: (Int, Int) -> Int = ::multiply
    val operatorAdd: (Int, Int) -> Int = ::add

    operatorMultiply(10, 5) // 50
    operatorAdd(5, 4) // 9

    val operatorMultiply2: (Int, Int) -> Int = { x: Int, y: Int -> x * y }
    val operatorAdd2: (Int, Int) -> Int = { x: Int, y: Int -> x + y }

    operatorMultiply2(10, 5) // 50
    operatorAdd2(5, 4) // 9

    val a = 5 and 4 // 101 & 100 = 100 (4)
    val b = 9.and(3) // 1001 & 0011 = 0001 (1)
    println(a)
    println(b)

    val and: (Int, Int) -> Int = Int::and
    and(1, 3) // the result is 1

    val and2: (Int, Int) -> Int = { x: Int, y: Int -> x.and(y) }
    and2(1, 3) // the result is 1

    val whatsGoingOnText: String = "What's going on here?"
    val indexWithinWhatsGoingOnText: (String, Int, Boolean) -> Int = whatsGoingOnText::indexOf

    println(indexWithinWhatsGoingOnText("going", 0, true)) // 7
    println(indexWithinWhatsGoingOnText("Hi", 0, true))  // -1
    println(indexWithinWhatsGoingOnText("what's", 0, false))  // -1
    println(indexWithinWhatsGoingOnText("what's", 0, true))  // 0

    val indexWithinWhatsGoingOnText2: (String, Int, Boolean) -> Int =
        { string: String, startIndex: Int, ignoreCase: Boolean ->
            whatsGoingOnText.indexOf(string, startIndex, ignoreCase)
        }

    println(indexWithinWhatsGoingOnText2("going", 0, true)) // 7
    println(indexWithinWhatsGoingOnText2("Hi", 0, true))  // -1
    println(indexWithinWhatsGoingOnText2("what's", 0, false))  // -1
    println(indexWithinWhatsGoingOnText2("what's", 0, true))  // 0

    val personGenerator: (String, String) -> Person = ::Person
    val johnFoster: Person = personGenerator("John", "Foster")

    val personGenerator2: (String, String) -> Person = { name, lastName -> Person(name, lastName) }
    val johnFoster2: Person = personGenerator2("John", "Foster")
}

fun isOdd(x: Int) = x % 2 != 0

fun isEven(x: Int) = x % 2 == 0

fun printNumbers(numbers: MutableList<Int>, filter: (Int) -> Boolean) {
    for (number in numbers) {
        if (filter(number)) print("$number ")
    }
}

class Person(private val name: String, private val lastname: String) {
    fun printFullName(): String {
        return ("full name: $name $lastname")
    }
}

fun multiply(x: Int, y: Int) = x * y

fun add(x: Int, y: Int) = x + y
