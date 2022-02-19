fun main() {
    @Suppress("SpellCheckingInspection")
    println(
        when (readLine()) {
            "gryffindor" -> "bravery"
            "hufflepuff" -> "loyalty"
            "slytherin" -> "cunning"
            "ravenclaw" -> "intellect"
            else -> "not a valid house"
        }
    )
}
