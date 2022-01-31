fun main() {
    val (a, b, c, n) = readLine()!!.split(" ").map { it.toInt() }

    var result = ""

    for (i in 0 until a) {
        result +=
            if (i % 2 == 0) {
                "A"
            } else {
                "B"
            }
    }
    for (i in 0 until b) {
        result +=
            if (i % 2 == 0) {
                "a"
            } else {
                "b"
            }
    }
    for (i in 0 until c) {
        result += "${i % 10}"
    }
    for (i in 0 until n - a - b - c) {
        result +=
            if (i % 2 == 0) {
                "!"
            } else {
                "%"
            }
    }
    println(result)
}
