fun main() {
    val city = "Paris"
    val temp = "24"

    println("Now, the temperature in $city is $temp degrees Celsius.")

    val value = "55"
    val currency = "dollars"
    val price = "$value $currency" // "55 dollars"

    println(price)

    val language = "Kotlin"
    println("$language has ${language.length} letters in the name")

    println("Have a nice $language!") // nice code
    // println("Have a nice " + language + "!") // bad practice
}
