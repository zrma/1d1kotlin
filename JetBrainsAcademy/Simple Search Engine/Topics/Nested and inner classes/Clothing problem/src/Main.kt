class Employee(val clothesSize: Int) {
    class Uniform {
        val uniformType = "suit"
        val uniformColor = "blue"
    }

    fun printUniformInfo() {
        val uniform = Uniform()
        println(
            "The employee wears a ${uniform.uniformColor} ${uniform.uniformType} in size $clothesSize"
        )
    }
}
