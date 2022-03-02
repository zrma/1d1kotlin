import kotlin.random.Random

fun generatePredictablePassword(seed: Int): String {
    val random = Random(seed)
    return List(10) { random.nextInt(33, 127).toChar() }.joinToString("")
}
