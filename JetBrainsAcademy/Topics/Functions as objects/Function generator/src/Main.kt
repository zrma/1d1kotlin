fun identity(x: Int): Int = x

fun half(x: Int): Int = x / 2

fun zero(x: Int): Int = 0

fun generate(functionName: String): (Int) -> Int {
    return when (functionName) {
        "identity" -> ::identity
        "half" -> ::half
        else -> ::zero
    }
}
