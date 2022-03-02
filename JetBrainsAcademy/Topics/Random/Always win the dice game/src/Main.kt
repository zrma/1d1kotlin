import kotlin.random.Random

fun createDiceGameRandomizer(n: Int): Int {
    var seed = 0
    while (true) {
        val random = Random(++seed)
        var sumA = 0
        repeat(n) { sumA += random.nextInt(1, 7) }
        var sumB = 0
        repeat(n) { sumB += random.nextInt(1, 7) }
        if (sumA < sumB) {
            return seed
        }
    }
}
