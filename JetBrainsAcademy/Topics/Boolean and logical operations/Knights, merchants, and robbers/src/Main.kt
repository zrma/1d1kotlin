fun main() {
    val firstAnswer = readLine().equals("true")
    val secondAnswer = readLine().equals("true")
    val confessor = readLine().equals("true")

    println(firstAnswer == secondAnswer && !confessor)
}
