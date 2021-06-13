fun main() {
    val x = readLine().equals("true")
    val y = readLine().equals("true")
    val z = readLine().equals("true")

    print(!(x && y) || z)
}
