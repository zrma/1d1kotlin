import java.util.*

fun swapInts(ints: IntArray): IntArray {
    return intArrayOf(ints[1], ints[0])
}

fun main() {
    val scanner = Scanner(System.`in`)
    while (scanner.hasNextLine()) {
        var ints =
            intArrayOf(
                scanner.nextLine().toInt(),
                scanner.nextLine().toInt(),
            )
        ints = swapInts(ints)
        println(ints[0])
        println(ints[1])
    }
}
