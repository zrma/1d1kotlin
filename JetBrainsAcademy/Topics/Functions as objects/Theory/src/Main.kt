fun main() {
    val sumObject = ::sum
    val sumObject1: (Int, Int) -> Int = ::sum

    println(sumObject(1, 2))
    println(sumObject1(1, 2))

    println(applyAndSum(1, 2, ::same)) // returns 3 = 1 + 2
    println(applyAndSum(1, 2, ::square)) // returns 5 = 1 * 1 + 2 * 2
    println(applyAndSum(1, 2, ::triple)) // returns 9 = 3 * 1 + 3 * 2

    val originalText = "I don't know... what to say..."
    val textWithoutDots = originalText.filter(::isNotDot)
    println(textWithoutDots)
}

fun sum(a: Int, b: Int): Int = a + b

fun sayHello() {
    println("Hello")
}

fun getRealGrade(x: Double) = x

fun getGradeWithPenalty(x: Double) = x - 1

fun getScoringFunction(isCheater: Boolean): (Double) -> Double {
    if (isCheater) {
        return ::getGradeWithPenalty
    }

    return ::getRealGrade
}

fun applyAndSum(a: Int, b: Int, transformation: (Int) -> Int): Int {
    return transformation(a) + transformation(b)
}

fun same(x: Int) = x

fun square(x: Int) = x * x

fun triple(x: Int) = 3 * x

fun isNotDot(c: Char): Boolean = c != '.'
