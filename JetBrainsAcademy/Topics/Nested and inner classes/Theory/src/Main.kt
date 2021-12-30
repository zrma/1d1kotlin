fun main() {
    val cloak = Superhero.MagicCloak()
    val hammer = Superhero.Hammer()
    println(cloak.magicPower)
    println(hammer.mightPower)

    val shield = Superhero()
    println(shield.power)

    @Suppress("RedundantExplicitType") val cat: Cat = Cat("Bob")
    val bow: Cat.Bow = cat.Bow("red")

    bow.printColor()
    bow.putOnABow()
}

class Superhero {
    val power = 1000

    class MagicCloak {
        val magicPower = 100
    }
    val magicPower = power * MagicCloak().magicPower

    class Hammer {
        val mightPower = 100
    }
    val mightPower = power * Hammer().mightPower
}

class Cat(val name: String) {
    fun sayMeow() {
        println("$name says: \"Meow\".")
    }

    inner class Bow(val color: String) {
        fun putOnABow() {
            sayMeow()
            println("The bow is on!")
        }

        fun printColor() {
            println("The cat named $name has a $color bow.")
        }
    }
    val catBow = Bow("Green")
}
