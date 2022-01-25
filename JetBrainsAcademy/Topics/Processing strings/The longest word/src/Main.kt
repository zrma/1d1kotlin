fun main() {
    var longest = ""
    readLine()!!.split(" ").forEach {
        if (it.length > longest.length) {
            longest = it
        }
    }
    println(longest)
}
