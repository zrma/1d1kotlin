fun main() {
    val age = 123 // an integer value
    if (age > 100) {
        println("Very experienced person")
    }

    @Suppress("SimplifyBooleanWithConstants", "ConstantConditionIf")
    if (3 == 4) {
        println("3 is 4")
    }

    val b = false // it is true or false (Boolean)
    @Suppress("ControlFlowWithEmptyBody")
    if (b) { // or !b
        // do something
    }

    val num = 123
    if (num % 2 == 0) {
        println("It's an even number")
    } else {
        println("It's an odd number")
    }

    val dollars = 1004 // your budget (Int)

    @Suppress("CascadeIf")
    if (dollars < 1000) {
        println("Buy a laptop")
    } else if (dollars < 2000) {
        println("Buy a personal computer")
    } else if (dollars < 100_000) {
        println("Buy a server")
    } else {
        println("Buy a data center or a quantum computer")
    }

    when {
        dollars < 1000 -> {
            println("Buy a laptop")
        }
        dollars < 2000 -> {
            println("Buy a personal computer")
        }
        dollars < 100_000 -> {
            println("Buy a server")
        }
        else -> {
            println("Buy a data center or a quantum computer")
        }
    }

    val n = 1234
    if (n % 2 == 0) {
        if (n % 3 == 0) {
            println("The number can be divided by 6")
        } else {
            println("The number can be divided by 2")
        }
    } else {
        println("The number cannot be divided by 2")
    }

    val n1 = 10
    val n2 = 20
    val max =
        if (n1 > n2) {
            println("Choose n1")
            n1
        } else {
            println("Choose n2")
            n2
        }
    println(max)

    val max1 = if (n1 > n2) n1 else n2
    println(max1)

    @Suppress("CascadeIf")
    println(
        if (n1 == n2) {
            "n1 equal n2"
        } else if (n1 > n2) {
            "n1 is greater than n2"
        } else {
            "n1 is less than bn2"
        }
    )

    println(
        when {
            n1 == n2 -> {
                "n1 equal n2"
            }
            n1 > n2 -> {
                "n1 is greater than n2"
            }
            else -> {
                "n1 is less than bn2"
            }
        }
    )

    var max2 = n1 // try to avoid var if possible
    if (n1 > n2) max2 = n2
    println(max2)

    val max3 = if (n1 > n2) n1 else n2
    println(max3)
}
