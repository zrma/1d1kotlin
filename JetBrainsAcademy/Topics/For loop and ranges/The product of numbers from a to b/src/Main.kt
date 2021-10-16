fun main() {
    println((readLine()!!.toLong() until readLine()!!.toLong()).reduce { acc, l -> acc * l })
}
