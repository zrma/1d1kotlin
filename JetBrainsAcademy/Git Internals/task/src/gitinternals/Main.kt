package gitinternals

import java.io.File
import java.util.zip.InflaterInputStream

fun main() {
  println("Enter .git directory location:")
  val gitDir = readln()

  println("Enter git object hash:")
  val hash = readln()

  val gitObjPath = "$gitDir/objects/${hash.substring(0, 2)}/${hash.substring(2)}"

  val gitObj = readGitObject(gitObjPath)
  val parsed = parseGitObject(gitObj)

  val header = parsed.first()
  header.split(" ").let { println("type:${it[0]} length:${it[1]}") }
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
