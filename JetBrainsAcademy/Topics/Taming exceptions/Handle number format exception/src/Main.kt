fun parseCardNumber(cardNumber: String): Long {
    val regex = Regex("\\d{4} \\d{4} \\d{4} \\d{4}")
    if (regex.matches(cardNumber)) {
        return cardNumber.replace(" ", "").toLong()
    }

    throw IllegalArgumentException("Invalid card number: $cardNumber")
}
