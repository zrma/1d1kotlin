fun main() {
    val greeting = "Hello"

    val first = greeting[0] // 'H'
    val second = greeting[1] // 'e'
    val five = greeting[4] // 'o'

    println("$first $second $five")

    val last = greeting[greeting.length - 1] // 'o'
    val preLast = greeting[greeting.length - 2] // 'l'

    println("$last $preLast")

    println(greeting.first()) // 'H'
    println(greeting.last()) // 'o'
    println(greeting.lastIndex) // 4

    val emptyString = ""
    // println(emptyString.length == 0) //true
    println(emptyString.isEmpty()) // true

    // val valString = "string"
    // valString[3] = 'o' // an error here!
    // var varString = "string"
    // varString[3] = 'o' // an error here too!

    var varString = "string"
    varString = "strong" // legal
    val valString = "string"
    // valString = "strong" // error, you cannot reassign val

    println("$varString $valString")

    val str0 = "first"
    val str1 = "second"
    var str2 = str1
    println(str2)

    str2 = "first"

    println(str0 == str2) // true
    println(str0 == str1) // false
    println(str0 != str1) // true

    println("\'H\' is the first letter of \"Hello world!\" string.")

    val largeString =
        """
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
    print(rawString)
}
