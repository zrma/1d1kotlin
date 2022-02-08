fun main() {
    val str = readLine()!!
    val subStr = readLine()!!

    println(getFrequency(str, subStr))
}

fun getFrequency(str: String, subStr: String): Int {
    var count = 0
    for (i in 0 until str.length - subStr.length + 1) {
        if (str.substring(i, i + subStr.length) == subStr) {
            count++
        }
    }
    return count
}
