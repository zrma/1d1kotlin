@Suppress("unused")
fun f(x: Double): Double {
    return when {
        x <= 0 -> f1(x)
        x < 1 -> f2(x)
        else -> f3(x)
    }
}

fun f1(x: Double): Double {
    return x * x + 1
}

fun f2(x: Double): Double {
    return 1 / (x * x)
}

fun f3(x: Double): Double {
    return x * x - 1
}
