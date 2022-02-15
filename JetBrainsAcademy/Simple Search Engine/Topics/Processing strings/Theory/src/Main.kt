fun main() {
    val sentence = "a long text"
    val wordsList: List<String> = sentence.split(" ") // ["a", "long", "text"]
    println(wordsList)

    val mutableWordList = sentence.split(" ").toMutableList() // MutableList ["a", "long", "text"]
    println(mutableWordList)

    val number = "+1-213-345-6789"
    val numberParts = number.split("-") // ["+1", "213", "345", "6789"]
    println(numberParts)

    val text = "That's one small step for a man, one giant leap for mankind."
    val textParts =
        text.split(",") // ["That's one small step for a man", " one giant leap for mankind."]
    println(textParts)

    val text1 = "I'm gonna be a programmer"
    val textParts1 = text1.split(" gonna be ") // ["I'm", "a programmer"]
    println(textParts1)

    val scientistName = "Isaac Newton"

    for (element in scientistName) {
        print("${element} ") // print the current character
    }

    val str = "strings are not primitive types!"

    var count = 0
    for (ch in str) {
        if (Character.isWhitespace(ch)) count++
    }

    println(count) // 4

    val rainbow = "ROYGCBV"

    for (index in rainbow.indices) {
        println("${index+1}: ${rainbow[index]}")
    }
}
