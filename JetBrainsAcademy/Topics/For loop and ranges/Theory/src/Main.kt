fun main() {
    for (i in 1..4) {
        println(i)
    }

    for (ch in 'a'..'c') {
        println(ch)
    }

    for (i in 4 downTo 1) {
        println(i)
    }

    for (i in 1..7 step 2) {
        println(i)
    }

    for (i in 7 downTo 1 step 2) {
        println(i)
    }

    val n = readLine()!!.toInt()
    var result = 1 // starting value of the factorial

    for (i in 2..n) { // the product from 2 to n
        result *= i
    }

    println(result)

    for (i in 2..10 step 2) {
        for (j in 2..10 step 2) {
            print(i * j)
            print('\t') // print the product of i and j followed by one tab
        }
        println()
    }
}
