fun main() {
    val numbers = intArrayOf(1, 2, 3, 4, 5) // It stores 5 elements of the Int type
    println(numbers.joinToString()) // 1, 2, 3, 4, 5

    val characters = charArrayOf('K', 't', 'l') // It stores 3 elements of the Char type
    println(characters.joinToString()) // K, t, l

    val doubles = doubleArrayOf(1.25, 0.17, 0.4) // It stores 3 elements of the Double type
    println(doubles.joinToString()) // 1.15, 0.17, 0.4

    val array =
        intArrayOf(
            1,
            2,
            3,
            4,
        ) // works since Kotlin 1.4
    println(array.joinToString())

    val numbers1 = IntArray(5) // an array of 5 integer numbers
    println(numbers1.joinToString())

    val doubles1 = DoubleArray(7) // an array of 7 doubles
    println(doubles1.joinToString())

    println(numbers.size) // 5
    println(array.size) // 4

    val numbers2 = IntArray(3) // numbers2: 0, 0, 0

    numbers2[0] = 1 // numbers2: 1, 0, 0
    numbers2[1] = 2 // numbers2: 1, 2, 0
    numbers2[2] = numbers2[0] + numbers2[1] // numbers2: 1, 2, 3

    println(numbers2[0]) // 1, the first element
    println(numbers2[2]) // 3, the last element

    // val elem = numbers2[3] // The program will throw ArrayIndexOutOfBoundsException.

    val alphabet = charArrayOf('a', 'b', 'c', 'd')

    val last = alphabet[alphabet.size - 1] // 'd'
    val preLast = alphabet[alphabet.size - 2] // 'c'

    println(last)
    println(preLast)

    println(alphabet.first()) // 'a'
    println(alphabet.last()) // 'd'
    println(alphabet.lastIndex) // 3

    val numbers3 = intArrayOf(1, 2, 3, 4)
    val numbers4 = intArrayOf(1, 2, 3, 4)
    val numbers5 = intArrayOf(1, 2, 3)

    println(numbers3.contentEquals(numbers4)) // true
    println(numbers3.contentEquals(numbers5)) // false

    val simpleArray = intArrayOf(1, 2, 3, 4)
    val similarArray = intArrayOf(1, 2, 3, 4)

    @Suppress("ReplaceArrayEqualityOpWithArraysEquals")
    println(simpleArray == simpleArray) // true, simpleArray points to the same object
    @Suppress("ReplaceArrayEqualityOpWithArraysEquals")
    println(simpleArray == similarArray) // false, similarArray points to another object
    println(simpleArray.contentEquals(simpleArray)) // true
    println(simpleArray.contentEquals(similarArray)) // true
}
