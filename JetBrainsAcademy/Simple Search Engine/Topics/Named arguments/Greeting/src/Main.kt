fun greetUser(
    name: String,
    admin: Boolean = false,
    smith: Boolean = false,
    honorific: String = "",
    greet: String = "Greetings"
): String {
    return if (!admin && !smith) {
        "$greet, $honorific $name"
    } else {
        "Matrix Error"
    }
}
// do not change lines above

fun greetNeo() = greetUser(greet = "Hello", honorific = "Mr.", name = "Anderson")
