fun main() {
    var prev = Int.MIN_VALUE
    var ascending = true
    repeat(readLine()!!.toInt()) {
        val cur = readLine()!!.toInt()
        ascending = ascending and (cur >= prev)
        prev = cur
    }

    if (ascending) {
        println("YES")
    } else {
        println("NO")
    }
}
