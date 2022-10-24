fun main() {
    val url = readLine()!!

    var password: String? = null

    val parameters = url.substringAfter("?").split("&")
    for (parameter in parameters) {
        val (key, value) = parameter.split("=")
        if (key == "pass") {
            password = value
        }
        if (value.isEmpty()) {
            println("$key : not found")
        } else {
            println("$key : $value")
        }
    }
    if (password != null) {
        println("password : $password")
    }
}