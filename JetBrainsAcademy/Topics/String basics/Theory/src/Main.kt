// You can experiment here, it won’t be checked

fun main() {
    val language = "Kotlin"
    println(language.length) // 6

    val empty = ""
    println(empty.length) // 0

    val str1 = "ab"
    val str2 = "cde"
    val result = str1 + str2
    println(result) // abcde

    val one = "1"
    val two = "2"
    val twelve = one + two
    println(one) // 1, no changes
    println(two) // 2, no changes
    println(twelve) // 12

    val firstName = "John"
    val lastName = "Smith"
    val fullName = "$firstName $lastName"
    println(fullName) // John Smith

    val stringPlusBoolean = "abc" + 10 + true
    println(stringPlusBoolean) // abc10true

    val code = "123" + 456 + "789"
    println(code) // 123456789

    // val errorString = 10 + "abc" // an error here!

    val stringAndNumbers = "abc" + 11 + 22
    println(stringAndNumbers) // abc1122

    val charPlusString = 'a' + "bc"
    println(charPlusString) // abc
    val stringPlusChar = "de" + 'f'
    println(stringPlusChar) // def

    val charPlusStringPlusInt = 'a' + "bc" + 123
    println(charPlusStringPlusInt) // abc123

    println("Hello".repeat(4)) // HelloHelloHelloHello

    println("Eat. Sleep. Code.\n".repeat(7)) // \n gives you a line feed (new line)

    // prints 'H' is the first letter of "Hello world!" string.
    println("\'H\' is the first letter of \"Hello world!\" string.")

    val largeString = """
    This is the house that Jack built.
      
    This is the malt that lay in the house that Jack built.
       
    This is the rat that ate the malt
    That lay in the house that Jack built.
       
    This is the cat
    That killed the rat that ate the malt
    That lay in the house that Jack built.
""".trimIndent() // removes the first and the last lines and trim indents
    print(largeString)

    val unevenString = """
        123
         456
          789""".trimIndent()
    print(unevenString)
    println()

    val rawString = """123
         456
          789
""".trimIndent()
    print(rawString )
}
