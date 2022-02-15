fun main() {
    val input = readLine()!!.split(" ")

    println(isSameCurrencies(input[0], input[1]))
}

enum class Country(val currency: String) {
    Germany("Euro"),
    Mali("CFA franc"),
    Dominica("Eastern Caribbean dollar"),
    Canada("Canadian dollar"),
    Spain("Euro"),
    Australia("Australian dollar"),
    Brazil("Brazilian real"),
    Senegal("CFA franc"),
    France("Euro"),
    Grenada("Eastern Caribbean dollar"),
    Kiribati("Australian dollar"),
    NULL("");

    companion object {
        fun findByCountry(name: String): Country {
            for (enum in values()) {
                if (name == enum.name) return enum
            }
            return NULL
        }
    }
}

fun isSameCurrencies(name0: String, name1: String): Boolean {
    val country0 = Country.findByCountry(name0)
    val country1 = Country.findByCountry(name1)

    return country0 != Country.NULL &&
        country1 != Country.NULL &&
        country0.currency == country1.currency
}
