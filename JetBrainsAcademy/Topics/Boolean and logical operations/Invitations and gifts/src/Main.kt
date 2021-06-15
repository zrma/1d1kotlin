fun main() {
    val (isInvited, hasGift) = List(2) { readLine()!!.toBoolean() }
    println(isInvited && hasGift)
}
