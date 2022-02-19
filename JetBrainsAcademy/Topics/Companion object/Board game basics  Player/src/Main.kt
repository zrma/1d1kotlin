class Player(val id: Int, val name: String, val hp: Int) {
    companion object {
        private val players = mutableListOf<Player>()

        fun create(name: String): Player {
            val player = Player(players.size, name, 100)
            players.add(player)
            return player
        }
    }
}
