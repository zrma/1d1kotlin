import kotlin.random.Random

fun main() {
    // generates an integer value between Int.MIN_VALUE and Int.MAX_VALUE (inclusive)
    println(Random.nextInt())
    // generates a long value between Long.MIN_VALUE and Long.MAX_VALUE (inclusive).
    println(Random.nextLong())
    // generates a float value between 0 (inclusive) and 1.0 (exclusive)
    println(Random.nextFloat())
    // generates a double value between 0 (inclusive) and 1.0 (exclusive)
    println(Random.nextDouble())
    // same thing one more time
    println(Random.nextDouble())

    // generates a non-negative integer value less than 100
    println(Random.nextInt(100))
    // generates an integer value between 1 (inclusive) and 100 (exclusive)
    println(Random.nextInt(1, 100))

    // generates a non-negative long value less than 100
    println(Random.nextLong(100))
    // generates a long value between 1 (inclusive) and 100 (exclusive)
    println(Random.nextLong(1, 100))

    // generates a non-negative double value less than 5.0
    println(Random.nextDouble(5.0))
    // generates a double value between 0.0 (inclusive) and 5.0 (exclusive)
    println(Random.nextDouble(0.0, 5.0))

    val randomGenerator42 = Random(42) // the generator takes the seed
    repeat(6) { println(randomGenerator42.nextInt(100)) }

    // the same generator we use when we call Random.nextInt(), Random.nextFloat() etc.
    val defaultGenerator = Random.Default
    repeat(6) { println(defaultGenerator.nextInt(100)) }
}
