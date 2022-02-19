class ChristmasTree(var treeColor: String) {

    // create function putTreeTopper()
    fun putTreeTopper(color: String) {
        TreeTopper(color).sparkle()
    }

    inner class TreeTopper(var topperColor: String) {

        // create function sparkle()
        fun sparkle() {
            println(
                "The sparkling $topperColor tree topper looks stunning on the $treeColor Christmas tree!"
            )
        }
    }
}
