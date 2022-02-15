fun main() {
    val greeting = "Hello"
    println(greeting.substring(0, 3)) // "Hel"
    println(greeting.substring(1, 3)) // "el"
    println(greeting.substring(2)) // "llo"
    println(greeting.substring(4, 5)) // "o"

    println(greeting.substringAfter('l')) // "lo"
    println(greeting.substringBefore('o')) // "Hell"
    println(greeting.substringBefore('z')) // "Hello"

    println(greeting.substringAfterLast('l')) // "o"
    println(greeting.substringBeforeLast('l')) // "Hel"

    val example = "Good morning..."
    println(example.replace("morning", "bye")) // "Good bye..."
    println(example.replace('.', '!')) // "Good morning!!!"

    example.replace("morning", "bye")
    println(example) // "Good morning..."

    val numbers = "one one two three"
    println(numbers.replaceFirst("one", "two")) // "two one two three"

    val upperCase = "UPPERCASE String"
    println(example.toLowerCase()) // uppercase string

    val lowerCase = "Lowercase String"
    println(example.toUpperCase()) // LOWERCASE STRING
}
