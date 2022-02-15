fun main() {
    val students = mapOf("Zhenya" to 5, "Vlad" to 4, "Nina" to 5)
    println(students) // output: {Zhenya=5, Vlad=4, Nina=5}

    val studentsName = mutableListOf("Zhenya", "Vlad", "Nina")
    val studentsMarks = mutableListOf(5, 4, 5)
    println(
        "${studentsName[0]}=${studentsMarks[0]}, ${studentsName[1]}=${studentsMarks[1]}, ${studentsName[2]}=${studentsMarks[2]}"
    )
    // output: Zhenya=5, Vlad=4, Nina=5

    val grade0 = students["Nina"]
    println("Nina's grade is: $grade0") // output: Nina's grade is: 5

    val (name1, grade1) = Pair("Zhenya", 5) // easy way to get the first and the second values
    println("Student name is: $name1 And their grade is: $grade1")
    // output: Student name is: Zhenya And their grade is: 5)

    val (name2, grade2) = "Vlad" to 4
    println("Student name is: $name2 And their grade is: $grade2")
    // output: Student name is: Vlad And their grade is: 4

    val p = Pair(2, 3)
    println("${p.first} ${p.second}") // 2 3
    val (first, second) = p
    println("$first $second") // 2 3

    @Suppress("RemoveExplicitTypeArguments") val staff0 = mapOf<String, Int>("John" to 1000)
    val staff1 = mapOf("Mike" to 1500)
    val emptyStringToDoubleMap = emptyMap<String, Double>()

    println(staff0) // output: {John=1000}
    println(staff1) // output: {Mike=1500}
    println(emptyStringToDoubleMap) // output: {}

    val employees = mapOf("Mike" to 1500, "Jim" to 500, "Sara" to 1000)

    if (!employees.isEmpty()) {
        println("Number of employees: ${employees.size}")
        println("Mike wants to earn ${employees["Mike"]}")
    }

    val isWanted = employees.containsKey("Jim")
    println("Does Jim want to be our employee? It's $isWanted")

    val isAnyoneWilling = employees.containsValue(500)
    println("Is anyone willing to earn $500? It's $isAnyoneWilling")

    for (employee in employees) println("${employee.key} ${employee.value}")

    for ((k, v) in employees) println("$k $v")

    val map = mapOf("a" to 1, "b" to 2, "c" to 3)
    println(map.get("a")) // 1
    println(map["b"]) // 2, idiomatic way

    for ((k, v) in map) {
        println("$k -> $v")
    }
}
