open class Me {
    open fun returnName(name: String): String = "My name is $name"
}

open class ActuallyMe : Me() {
    override fun returnName(name: String): String = "Actually, my name is $name"
}