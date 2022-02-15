class Player(val id: Int, val name: String, val speed: Int, val health: Int, val armor: Int) {
    companion object {
        val baseSpeed = 7
        val baseHealth = 100
        val baseArmor = 100
        val maxSpeed = 13
        val maxHealth = 140
        val maxArmor = 100
    }
}
