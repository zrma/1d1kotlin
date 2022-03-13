fun main() {
    val number = "+1-213-345-6789"
    val parts = number.split("-") // {"+1", "213", "345", "6789"}
    println(parts)

    val brackets = "+1-(213)-345-6789"
    // splitting all substrings in number with brackets
    val splitBrackets = brackets.split("(-\\(|\\)-|-)".toRegex()) // {"+1", "213", "345", "6789"}
    println(splitBrackets)

    // splitting only two substring
    val splitFirstBrackets = number.split("(-\\(|\\)-|-)".toRegex(), 2) // {"+1", "213-345-6789"}
    println(splitFirstBrackets)

    // splitting all substrings in number without brackets
    val splitNumber = number.split("(-\\(|\\)-|-)".toRegex()) // {"+1", "213", "345", "6789"}
    println(splitNumber)

    val withDigits =
        "The first test flight of Falcon 9 was on June 4, 2010, " +
            "from Cape Canaveral, Florida, and the first resupply mission " +
            "to the ISS was made on October 7, 2012."
    val processedString = withDigits.replace("\\d+".toRegex(), "[digits]")
    println(processedString)

    val regex0 = """[+]?[(]?[0-9]{1,4}[)]?[-0-9]*""".toRegex() // phone number template
    val matchResult0 =
        regex0.find(
            "Her phone number is +1-234-567-89-01. You can also call the second one: +1-111-568-01-01"
        )!!
    println(matchResult0.value) // +1-234-567-89-01

    val regex1 = """\d{4}-\d{2}-\d{2}""".toRegex() // date template in format YYYY-MM-DD
    val matchResult1 =
        regex1.findAll(
            "Harry was born 1980-07-31 in the Godric's Hollow." +
                "In 1997-12-24, on Christmas Eve, he returned there" +
                "for the legendary Gryffindor sword"
        )
    for (matches in matchResult1) println(matches.value)
    // 1980-07-31
    // 1997-12-24

}
