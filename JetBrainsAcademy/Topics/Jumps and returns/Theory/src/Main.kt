fun main() {
    println("Before the loop")
    for (i in 1..10) {
        if (i == 3) {
            break
        }
        println(i)
    }
    println("After the loop")

    var result = ""
    for (i in "hello world") {
        if (i == 'o') continue
        result += i
    }
    println(result)

    for (i in 1..4) {
        for (j in 1..4) {
            if (j == 2) continue // you want to ignore j = 2
            if (i <= j) break // you will print the string if i is greater than j
            println("i = $i, j = $j")
        }
        println("Finished to examine i = $i")
    }

    loop@ for (i in 1..3) {
        for (j in 1..3) {
            println("i = $i, j = $j")
            if (j == 3) break@loop
        }
    }

    loop@ for (i in 1..3) {
        for (j in 1..3) {
            for (k in 1..3) {
                if (k == 2) continue@loop
                println("i = $i, j = $j, k = $k")
            }
        }
    }

    Loop@ for (i in 1..10) {
        when (i) {
            3 -> continue@Loop
            6 -> break@Loop
            else -> println(i)
        }
    }

    for (i in 1..10) {
        when (i) {
            3 -> continue
            6 -> break
            else -> println(i)
        }
    }

    for (i in 1..10) {
        for (j in 1..10) {
            println("i = $i, j = $j")
            if (j == 3) return
        }
    }
}
