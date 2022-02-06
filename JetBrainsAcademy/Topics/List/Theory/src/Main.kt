fun main() {
    val mutableCars = mutableListOf("BMW", "Honda", "Mercedes")
    println(mutableCars) // output: [BMW, Honda, Mercedes]

    mutableCars[0] = "Renault"
    println(mutableCars) // output: [Renault, Honda, Mercedes]

    val immutableCars = listOf("BMW", "Honda", "Mercedes")
    println(immutableCars) // output: [BMW, Honda, Mercedes]
    // immutableCars[0] = "Renault" // Error

    val textUsMethod = listOf("SMS", "Email")
    println(textUsMethod) // output: [SMS, Email]

    val staff = emptyList<String>()
    println(staff) // output: []

    val partyList = listOf("Fred", "Emma", "Isabella", "James", "Olivia")
    if (partyList.isNotEmpty()) {
        val size = partyList.size
        val whoIsFirst = partyList[0]
        println(
            "The party will not be lonesome! We already got $size people. And $whoIsFirst was the first to arrive today!"
        )
        // The party will not be lonesome! We already got 5 people. And Fred was the first to arrive
        // today!
    }

    println("Emma came in ${partyList.indexOf("Emma") + 1}") // Emma came in 2
    println(
        "Guys, is it true that Isabella came? It's ${partyList.contains("Isabella")}"
    ) // Guys, is it true that Isabella came? It's true

    val participants = listOf("Fred", "Emma", "Isabella")

    for (participant in participants) {
        println("Hello $participant!")
    }
    // Hello Fred!
    // Hello Emma!
    // Hello Isabella!
}
