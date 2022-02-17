fun main() {
    val string = "cat" // creating the "cat" string
    val regex = string.toRegex() // creating the "cat" regex

    val regexOfCet = Regex("cat") // creating a "cat" regex
    println(regexOfCet.matches("cat")) // true

    val stringCat = "cat"
    val stringDog = "dog"
    val stringCats = "cats"

    println(stringCat.matches(regex)) // true
    println(stringDog.matches(regex)) // false
    println(stringCats.matches(regex)) // false

    val regexDot = Regex("cat.") // creating the "cat." regex

    val stringCatDot = "cat."
    val stringEmotionalCat = "cat!"
    val stringCatWithSpace = "cat "
    val stringCatN = "cat\n"

    println(stringCatDot.matches(regexDot)) // true
    println(stringEmotionalCat.matches(regexDot)) // true
    println(stringCatWithSpace.matches(regexDot)) // true
    println(stringCatN.matches(regexDot)) // false

    val regexOpt = Regex("cats?") // creating the "cats?" regex

    val stringManyCats = "cats"

    println(stringCat.matches(regexOpt)) // true
    println(stringManyCats.matches(regexOpt)) // true

    val regexDotOpt = Regex("cat.?") // creating the "cat.?" regex

    val stringCot = "cot"

    println(stringCat.matches(regexDotOpt)) // true
    println(stringManyCats.matches(regexDotOpt)) // true
    println(stringEmotionalCat.matches(regexDotOpt)) // true
    println(stringCot.matches(regexDotOpt)) // false

    val regexEsc = Regex("cats\\?")

    val stringEmotionalCats = "cats?"

    println(stringCat.matches(regexEsc)) // false
    println(stringManyCats.matches(regexEsc)) // false
    println(stringEmotionalCats.matches(regexEsc)) // true
}
