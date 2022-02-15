fun main() {
    val input = readLine()!![0]
    for (c in 'a'..'z') {
        if (input == c) {
            return
        }
        print(c)
    }
}
