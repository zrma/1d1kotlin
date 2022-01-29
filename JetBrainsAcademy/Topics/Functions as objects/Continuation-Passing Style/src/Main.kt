fun square(value: Int, context: Any, continuation: (Int, Any) -> Unit) {
    continuation(value * value, context)
}
