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

  val (gitObj, origData) = readGitObject(gitObjPath)
  val parsed = parseGitObject(gitObj)

  printParsedGitObj(parsed, origData)
}

fun parseGitObject(gitObject: String): List<String> {
  // split first NULL char of gitObject
  val split = gitObject.split("\u0000", limit = 2)
  val header = split[0]
  val body = split[1].split("\n").filter { it.isNotEmpty() }

  return listOf(header) + body
}

fun readGitObject(location: String): Pair<String, ByteArray> {
  val file = File(location)
  val bytes = file.readBytes()
  return Pair(
      InflaterInputStream(bytes.inputStream()).bufferedReader().readText(),
      InflaterInputStream(bytes.inputStream()).readAllBytes(),
  )
}

fun printParsedGitObj(parsed: List<String>, origData: ByteArray) {
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
    "TREE" -> {
      var tree = origData.dropWhile { it != 0.toByte() }.drop(1).toByteArray()
      while (tree.isNotEmpty()) {
        val (treeVal, tree1) = parseTree(tree)
        tree = tree1
        val (mode, hash, name) = treeVal
        println("$mode $hash $name")
      }
    }
  }
}

fun parseTree(tree: ByteArray): Pair<Triple<String, String, String>, ByteArray> {
  val mode =
      tree.takeWhile { it.toInt().toChar() != ' ' }.map { it.toInt().toChar() }.joinToString("")
  val name =
      tree
          .drop(mode.length + 1)
          .takeWhile { it != 0.toByte() }
          .map { it.toInt().toChar() }
          .joinToString("")
  val hash =
      tree.drop(mode.length + name.length + 2).take(20).joinToString("") { "%02x".format(it) }

  return Pair(Triple(mode, hash, name), tree.drop(mode.length + name.length + 22).toByteArray())
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
