fun main() {
    val zero = 0
    val one = 1
    val oneMillion = 1_000_000

    println(zero)
    println(one)
    println(oneMillion)

    val twoMillion = 2_000_000L
    val bigNumber = 1_000_000_000_000_000
    val ten: Long = 10

    println(twoMillion)
    println(bigNumber)
    println(ten)

    val shortNumber: Short = 15
    val byteNumber: Byte = 15

    println(shortNumber)
    println(byteNumber)

    val pi = 3.1415
    val e = 2.71828f
    val fraction: Float = 1.51F

    println(pi)
    println(e)
    println(fraction)

    println(Int.MIN_VALUE) // -2147483648
    println(Int.MAX_VALUE) // 2147483647
    println(Long.MIN_VALUE) // -9223372036854775808
    println(Long.MAX_VALUE) // 9223372036854775807

    println(Int.SIZE_BYTES) // 4
    println(Int.SIZE_BITS) // 32

    val lowerCaseLetter = 'a'
    val upperCaseLetter = 'Q'
    val number = '1'
    val space = ' '
    val dollar = '$'

    println(lowerCaseLetter)
    println(upperCaseLetter)
    println(number)
    println(space)
    println(dollar)

    val enabled = true
    val bugFound = false

    println(enabled)
    println(bugFound)

    val creditCardNumber = "1234 5678 9012 3456"
    val message = "Learn Kotlin instead of Java."

    println(creditCardNumber)
    print(message)
}
