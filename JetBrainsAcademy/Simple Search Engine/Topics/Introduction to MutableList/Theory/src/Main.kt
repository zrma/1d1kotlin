fun main() {
    val numbers = mutableListOf(10.8, 14.3, 13, 5, 12.1, 9.7)
    println(numbers) // [10.8, 14.3, 13,5, 12.1, 9.7]

    @Suppress("RemoveExplicitTypeArguments") val mutableListA = mutableListOf<Int>(1, 2, 3, 4, 3)
    println(mutableListA) // [1, 2, 3, 4, 3]

    // declaring a mutable list of strings
    @Suppress("RemoveExplicitTypeArguments")
    val mutableListB = mutableListOf<String>("Kotlin", "JetBrains")
    println(mutableListB) // [Kotlin, JetBrains]

    // declaring an empty mutable list of booleans
    val mutableListC = mutableListOf<Boolean>()
    println("Empty list $mutableListC") // Empty list []

    // Also, Kotlin allows you to not explicitly specify what type of data the list stores:
    val mutableListD = mutableListOf(1, 2, 3, 4, 3)
    println(mutableListD) // [1, 2, 3, 4, 3]

    val regex = "\\s+".toRegex() // 1 or more whitespace character (space, tabs etc.)
    val str = "1 2\t\t3  4\t5  6"
    val nums = str.split(regex).map { it.toInt() }.toMutableList()
    println(nums.joinToString()) // 1, 2, 3, 4, 5, 6

    val listA = MutableList(5) { 0 }
    println(listA) // [0, 0, 0, 0, 0]

    val listB = MutableList(5) { "a" }
    println(listB) // [a, a, a, a, a]

    val numbersA = mutableListOf(1, 2, 3, 4, 5)
    println(numbersA.size) // 5

    val numbersB = mutableListOf(0, 0, 0) // numbers: 0, 0, 0

    numbersB[0] = 1 // numbersB: 1, 0, 0
    numbersB[1] = 2 // numbersB: 1, 2, 0
    numbersB[2] = numbersB[0] + numbersB[1] // numbersB: 1, 2, 3

    println(numbersB[0]) // 1, the first element
    println(numbersB[2]) // 3, the last element

    // Exception in thread "main" java.lang.IndexOutOfBoundsException: Index: 3, Size: 3
    // val elem = numbersB[3]

    val alphabet = mutableListOf('a', 'b', 'c', 'd')

    val last = alphabet[alphabet.size - 1] // 'd'
    println(last)
    val preLast = alphabet[alphabet.size - 2] // 'c'
    println(preLast)

    println(alphabet.first()) // 'a'
    println(alphabet.last()) // 'd'
    println(alphabet.lastIndex) // 3
}
