package gitinternals

import java.io.File
import java.util.zip.InflaterInputStream

fun main() {
  println("Enter git object location:")
  val location = readln()
  val gitObject = readGitObject(location)
  val parsed = parseGitObject(gitObject)

  parsed.forEach { println(it) }
}

fun parseGitObject(gitObject: String): List<String> {
  return gitObject.split("\u0000", "\n").filter { it.isNotEmpty() }
}

fun readGitObject(location: String): String {
  val file = File(location)
  val bytes = file.readBytes()
  val inflater = InflaterInputStream(bytes.inputStream())
  return inflater.bufferedReader().readText()
}
