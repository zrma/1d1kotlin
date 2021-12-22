import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)

    var curIdx = 1
    var maxIdx = 1
    var maxVal = scanner.nextInt()
    while (scanner.hasNext()) {
        curIdx++
        val curVal = scanner.nextInt()
        if (maxVal < curVal) {
            maxVal = curVal
            maxIdx = curIdx
        }
    }
    println("$maxVal $maxIdx")
}
