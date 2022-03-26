fun main() {
    val client = Client()

    val name = client.name // prints Somebody wants to know Unknown name
    println(name) // prints Unknown
    println(client.info) // name = Unknown, age = 18

    client.name = "Lester"
    client.age = 20
    println(client.name) // prints Lester
    println(client.info) // name = Lester, age = 20

    client.age = -1 // Age cannot be negative. Set to 18.
    println(client.age) // 18

    val client0 = Client()
    println(client0.name) // prints Unknown
    println(client0.info) // name = Unknown, age = 18

    println(client.passport.number) // 1234567

    // client.passport = Passport("2345678") // This will not work.

    client.passport.number = "2345678" // This will change the passport number
    // prints Passport number has changed
    println(client.passport.number) // 2345678
}

class Client {
    var name = "Unknown"
        get() {
            println("Somebody wants to know $field name")
            return field
        }
        set(value) {
            println("The name is changing. Old value is $field. New value is $value.")
            field = value
        }
    var age: Int = 18
        set(value) {
            field =
                if (value < 0) {
                    println("Age cannot be negative. Set to $defaultAge")
                    defaultAge
                } else value
        }
    private val defaultAge = 18
    val info: String
        get() {
            return "name = $name, age = $age"
        }
    val passport = Passport("1234567")
}

class Passport(number: String) {
    var number = number
        set(value) {
            println("Passport number has changed.")
            field = value
        }
}
