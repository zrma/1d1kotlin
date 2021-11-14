@Suppress("unused")
fun subtractTwoNumbers(a: Long, b: Long) {
    println(a - b)
}

@Suppress("unused")
fun sumTwoNumbers(a: Long, b: Long) {
    println(a + b)
}

@Suppress("unused")
fun divideTwoNumbers(a: Long, b: Long) {
    if (b == 0L) {
        println("Division by 0!")
    } else {
        println(a / b)
    }
}

@Suppress("unused")
fun multiplyTwoNumbers(a: Long, b: Long) {
    println(a * b)
}
