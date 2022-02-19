class Block(val color: String) {
    object BlockProperties {
        var length: Int = 0
        var width: Int = 0

        fun blocksInBox(length: Int, width: Int): Int {
            return (length / BlockProperties.length) * (width / BlockProperties.width)
        }
    }
}
