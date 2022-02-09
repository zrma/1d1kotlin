fun main() {
    val valStaff = mapOf("John" to 500, "Mike" to 1000, "Lara" to 1300)
    println(valStaff) // output: {John=500, Mike=1000, Lara=1300}

    var varStaff =
        mapOf( // you cannot reassing an immutable reference, so you need to use var
            "John" to 500,
            "Mike" to 1000,
            "Lara" to 1300
        )
    @Suppress("SuspiciousCollectionReassignment") varStaff += "Jane" to 700 // reassignment
    println(varStaff) // output: {John=500, Mike=1000, Lara=1300, Jane=700}

    val staff = mutableMapOf("John" to 500, "Mike" to 1000, "Lara" to 1300)

    staff["Nika"] = 999

    println(staff) // output: {John=500, Mike=1000, Lara=1300, Nika=999}

    val students = mutableMapOf<String, Int>("Nika" to 19, "Mike" to 23)
    println(students) // output: {Nika=19, Mike=23}

    val carsPerYear = mutableMapOf(1999 to 30000, 2021 to 202111)
    println(carsPerYear) // output: {1999=30000, 2021=202111}

    val mapCarsPerYear = mapOf(1999 to 30000, 2021 to 202111)
    val mutCarsPerYear = mapCarsPerYear.toMutableMap()
    mutCarsPerYear[2020] = 2020
    println(mutCarsPerYear) // output: {1999=30000, 2021=202111, 2020=2020}}
    println(mapCarsPerYear) // output: {1999=30000, 2021=202111}

    val groupOfStudents = mutableMapOf<String, Int>() // empty mutable map
    @Suppress("ReplacePutWithAssignment") groupOfStudents.put("John", 4)
    groupOfStudents["Mike"] = 5
    groupOfStudents["Anastasia"] = 10

    val studentsFromOregon = mapOf("Alexa" to 7)

    groupOfStudents.putAll(studentsFromOregon)

    println(groupOfStudents) // output: {John=4, Mike=5, Anastasia=10, Alexa=7}

    val groceries0 = mutableMapOf<String, Int>()

    groceries0["Potato"] = 5
    println(groceries0) // output: {Potato=5}

    groceries0["Potato"] = 10
    println(groceries0) // output: {Potato=10}

    val groceries1 = mutableMapOf<String, Int>()

    groceries1 += mapOf("Potato" to 5)
    groceries1 += "Sprite" to 1

    println(groceries1) // output: {Potato=5, Sprite=1}

    val groceries = mutableMapOf("Potato" to 10, "Coke" to 5, "Chips" to 7)

    groceries.remove("Potato")
    println(groceries) // output: {Coke=5, Chips=7}

    groceries.clear()
    println(groceries) // output: {}

    val cars = mutableMapOf<String, Double>()
    cars["Ford"] = 100.500
    cars["Kia"] = 500.15

    println(cars) // output: {Ford=100.5, Kia=500.15}

    cars -= "Kia"
    println(cars) // output: {Ford=100.5}
}
