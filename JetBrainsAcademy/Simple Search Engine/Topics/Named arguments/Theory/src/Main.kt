fun main(args: Array<String>) {
    val amount0 = calcEndDayAmount(startAmount = 1000, ticketPrice = 10, soldTickets = 500) // 6000
    println(amount0)

    val amount1 = calcEndDayAmount(ticketPrice = 10, soldTickets = 500, startAmount = 1000) // 6000
    println(amount1)

    val amount2 = calcEndDayAmount(1000, ticketPrice = 10, soldTickets = 500) // 6000
    println(amount2)

    calcEndDayAmount(ticketPrice = 10, 500, 1000) // Incorrect invocation!
    calcEndDayAmount(startAmount = 1000, 10, 500) // OK

    calcEndDayAmount(soldTickets = 500, ticketPrice = 10, startAmount = 500) // OK
    calcEndDayAmount(soldTickets = 500, ticketPrice = 10, 500) // Incorrect invocation!
}

fun calcEndDayAmount(startAmount: Int, ticketPrice: Int, soldTickets: Int) =
    startAmount + ticketPrice * soldTickets
