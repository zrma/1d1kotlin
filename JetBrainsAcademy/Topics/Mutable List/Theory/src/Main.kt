fun main() {
    val valPlaces = listOf("Paris", "Moscow", "Tokyo")
    println(valPlaces) // output: [Paris, Moscow, Tokyo]

    var varPlaces = listOf("Paris", "Moscow", "Tokyo") // note var keyword
    @Suppress("SuspiciousCollectionReassignment")
    varPlaces += "Saint-Petersburg" // reassignment, slow operation
    println(varPlaces) // output: [Paris, Moscow, Tokyo, Saint-Petersburg]

    val mutablePlaces = mutableListOf("Paris", "Moscow", "Tokyo")
    mutablePlaces.add("Saint-Petersburg")
    println(mutablePlaces) // output: [Paris, Moscow, Tokyo, Saint-Petersburg]

    val cars = mutableListOf("Ford", "Toyota", "Audi", "Mazda", "Tesla")
    println(cars) // output: [Ford, Toyota, Audi, Mazda, Tesla]

    val emptyCars = mutableListOf<String>()
    println(emptyCars) // output: []

    val mutableCars = listOf("Ford", "Toyota").toMutableList()
    mutableCars.add("Tesla")
    println(mutableCars) // output: [Ford, Toyota, Tesla]

    val products = listOf("Milk", "Cheese", "Coke")

    val finalList = products.toMutableList()
    finalList.add("Chips")
    finalList[0] = "Water" // or finalList.set(0, "Water")
    println(finalList) // output: [Water, Cheese, Coke, Chips]
}
