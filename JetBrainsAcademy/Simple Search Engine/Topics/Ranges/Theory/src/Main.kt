fun main() {
    val a = 1
    val b = 3
    val c = 2

    // val within = a <= c && c <= b
    val within = c in a..b
    println(within) // true

    println(5 in 5..15) // true
    println(12 in 5..15) // true
    println(15 in 5..15) // true
    println(20 in 5..15) // false

    // val withinExclRight = c in a..b - 1 // a <= c && c < b
    val withinExclRight = c in a until b // a <= c && c < b
    println(withinExclRight) // true

    val notWithin = 100 !in 10..99 // true
    println(notWithin)

    val withinOr =
        c in 5..10 || c in 20..30 || c in 40..50 // true if c is within at least one range
    println(withinOr) // false

    val range = 100..200
    println(300 in range) // false

    println('b' in 'a'..'c') // true
    println('k' in 'a'..'e') // false

    println("hello" in "he".."hi") // true
    println("abc" in "aab".."aac") // false
}
