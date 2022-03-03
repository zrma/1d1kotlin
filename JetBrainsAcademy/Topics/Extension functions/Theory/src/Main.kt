import java.util.*

fun main() {
    fun repeated(string: String): String = string + string

    println(repeated("ha")) // "haha"

    fun String.repeated(): String = this + this

    println("ha".repeated()) // "haha"

    class Client(val name: String, val age: Int)

    fun Client.getInfo() = "$name $age" // Client is the receiver type

    val client = Client("John", 32)
    print(client.getInfo()) // client is the receiver object

    class A {
        fun member() = println("hi from member")
    }

    @Suppress("unused") fun A.extension() = println("hi from extension")
    @Suppress("unused", "EXTENSION_SHADOWED_BY_MEMBER")
    fun A.member() = println("bye from not member")

    A().extension()
    A().member()

    @Suppress("unused")
    fun String.spaceToCamelCase(): String {
        return this.lowercase(Locale.getDefault()).split(" ").joinToString("") {
            it.replaceFirstChar { c -> c.titlecase(Locale.getDefault()) }
        }
    }

    println("Convert this to camelcase".spaceToCamelCase())
}
