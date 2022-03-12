fun calculateBrakingDistance(v1Str: String, aStr: String): Int {
    return try {
        val v1 = v1Str.toInt()
        val a = aStr.toInt()
        -(v1 * v1) / (2 * a)
    } catch (e: ArithmeticException) {
        println("The car does not slow down!")
        -1
    } catch (e: Exception) {
        println(e.message)
        -1
    }
}
