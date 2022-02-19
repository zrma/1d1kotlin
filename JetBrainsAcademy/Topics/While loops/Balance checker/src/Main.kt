fun main() {
    var balance = readLine()!!.toInt()
    val purchase = readLine()!!.split(" ").map { it.toInt() }.iterator()

    var enough = true
    do {
        val n = purchase.next()
        if (n <= balance) {
            balance -= n
        } else {
            enough = false
            print(
                "Error, insufficient funds for the purchase. Your balance is $balance, but you need $n."
            )
            break
        }
    } while (purchase.hasNext())

    if (enough) {
        print("Thank you for choosing us to manage your account! Your balance is $balance.")
    }
}
