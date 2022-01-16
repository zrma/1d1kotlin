fun main() {
    val input = readLine()!!

    var result = ""
    var cur = input[0]
    var cnt = 1

    for (i in 1..input.lastIndex) {
        if (input[i] == cur) {
            cnt++
        } else {
            result += "$cur$cnt"
            cur = input[i]
            cnt = 1
        }
    }
    result += "$cur$cnt"
    println(result)
}
