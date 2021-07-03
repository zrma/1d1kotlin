fun main() {
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

    val ch = '\u0040' // it represents '@'
    println(ch) // @

    val ch0 = 'a'
    println(ch0.toInt()) // 97
    val num = 97
    println(num.toChar()) // a

    val first: Char = "Hello World".first()
    println(first)

    val ch1 = 'b'
    val ch2 = ch1 + 1 // 'c'
    val ch3 = ch2 - 2 // 'a'
    println(ch3)

    // val ch = 'a'
    // val ch1 = 1 + ch // Error
    // val charsSum = 'a' + 'b' // Error

    var ch4 = 'A'

    ch4 += 10
    println(ch4) // 'K'
    println(++ch4) // 'L'
    println(++ch4) // 'M'
    println(--ch4) // 'L'

    print('\t') // makes a tab
    print('a') // prints 'a'
    print('\n') // goes to a new line
    print('c') // prints 'c'

    println()

    @Suppress("SimplifyBooleanWithConstants") println('a' < 'c') // true
    @Suppress("SimplifyBooleanWithConstants") println('x' >= 'z') // false

    @Suppress("SimplifyBooleanWithConstants") println('D' == 'D') // true
    @Suppress("SimplifyBooleanWithConstants")
    println('Q' != 'q') // true, because capital and small letters are not the same

    @Suppress("SimplifyBooleanWithConstants")
    println('A' < 'a') // true, because capital Latin letters are placed before small ones

    val zero = "012".first()
    var isDigit = zero in '\u0030'..'\u0039'
    println(isDigit) // true

    val a = "abc".first()
    isDigit = a in '\u0030'..'\u0039'
    println(isDigit) // false

    val one = '1'

    isDigit = one.isDigit() // true
    val isLetter = one.isLetter() // false

    println(isDigit)
    println(isLetter)

    val capital = 'A'
    val small = 'e'

    val isLetterOrDigit = capital.isLetterOrDigit() // true
    println(isLetterOrDigit)

    val isUpperCase = capital.isUpperCase() // true
    val isLowerCase = capital.isLowerCase() // false
    println(isUpperCase)
    println(isLowerCase)

    val capitalE = small.toUpperCase() // 'E'
    println(capitalE)
}
