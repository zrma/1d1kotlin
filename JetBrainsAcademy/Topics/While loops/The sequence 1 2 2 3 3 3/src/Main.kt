fun main() {
    var n = readLine()!!.toInt()
    var i = 1
    do {
        repeat(i) {
            print("$i ")
            n--
            if (n == 0) {
                return
            }
        }
        i++
    } while (n > 0)
}
