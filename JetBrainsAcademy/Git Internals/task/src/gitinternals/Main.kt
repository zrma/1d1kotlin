package gitinternals

import java.io.File
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.util.zip.InflaterInputStream

fun main() {
  println("Enter .git directory location:")
  val gitDir = readln()

  println("Enter git object hash:")
  val hash = readln()

  val gitObjPath = "$gitDir/objects/${hash.substring(0, 2)}/${hash.substring(2)}"

  val gitObj = readGitObject(gitObjPath)
  val parsed = parseGitObject(gitObj)

  printParsedGitObj(parsed)
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

fun printParsedGitObj(parsed: List<String>) {
  val header = parsed.first()
  val contentType = header.split(" ").first().uppercase()
  println("*$contentType*")

  var body = parsed.drop(1)

  when (contentType) {
    "COMMIT" -> {
      val tree = body.first().split(" ")[1]
      body = body.drop(1)
      println("tree: $tree")

      val parents = body.filter { it.startsWith("parent") }
      body = body.filter { !it.startsWith("parent") }
      if (parents.isNotEmpty()) {
        println("parents: ${parents.joinToString(" | ") { it.split(" ").last() }}")
      }

      val (authorName, authorEmail, authorDate) = parseAuthor(body.first())
      body = body.drop(1)
      println("author: $authorName $authorEmail original timestamp: $authorDate")

      val (committerName, committerEmail, committerDate) = parseAuthor(body.first())
      body = body.drop(1)
      println("committer: $committerName $committerEmail commit timestamp: $committerDate")

      println("commit message:")

      body.forEach { println(it) }
    }
    "BLOB" -> {
      body.forEach { println(it) }
    }
  }
}

fun parseAuthor(line: String): Triple<String, String, String> {
  val lines = line.split(" ")
  val name = lines[1]
  val email = lines[2].removePrefix("<").removeSuffix(">")
  val date =
      LocalDateTime.ofEpochSecond(lines[3].toLong(), 0, ZoneOffset.of(lines[4]))
          .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) +
          " " +
          ZoneOffset.of(lines[4])
  return Triple(name, email, date)
}
