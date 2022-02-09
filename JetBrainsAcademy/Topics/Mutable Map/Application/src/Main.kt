fun addUser(
    userMap: Map<String, String>,
    login: String,
    password: String
): MutableMap<String, String> {
    val newUserMap = userMap.toMutableMap()
    if (userMap.containsKey(login)) {
        println("User with this login is already registered!")
        return newUserMap
    }
    newUserMap[login] = password
    return newUserMap
}
