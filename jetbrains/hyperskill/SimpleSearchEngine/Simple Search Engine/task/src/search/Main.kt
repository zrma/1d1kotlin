package search

fun main() {
  val inputStrings = readLine()
  val targetString = readLine()

  inputStrings?.split(" ")?.let { ss ->
    val idx = ss.indexOf(targetString)
    if (idx >= 0) {
      print(idx + 1)
    } else {
      print("Not found")
    }
  }
}
