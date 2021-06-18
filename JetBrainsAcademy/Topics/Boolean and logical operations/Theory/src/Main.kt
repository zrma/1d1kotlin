fun main() {
    var t = true
    val f = false
    println(t)
    println(f)
    println("true".toBoolean())
    println("True".toBoolean())
    println("TRue".toBoolean())
    println("T".toBoolean())
    println("false".toBoolean())
    val b: Boolean = readLine()!!.toBoolean()
    println(b)

    t = !f

    var b1 = f && f // false
    var b2 = f && t // false
    var b3 = t && f // false
    var b4 = t && t // true
    println("$b1 $b2 $b3 $b4")

    b1 = f || f
    b2 = f || true
    b3 = true || f
    b4 = true || true
    println("$b1 $b2 $b3 $b4")

    b1 = f xor f
    b2 = f xor true
    b3 = true xor f
    b4 = true xor true
    println("$b1 $b2 $b3 $b4")

    val bool = t && !f
    println(bool)

    val cold = false
    val dry = true
    val summer = false

    val hiking = dry && (!cold || summer)
    println(hiking)
}
