package me.stasiak.flagship.application

class CustomLogger(val name: String) {
    fun log(text: String) {
        println("$name: $text")
    }
}

context(CustomLogger)
fun store(text: String) {
    log("Stored $text on disk")
}

fun contextReceiversExample() {
    val logger = CustomLogger("Example logger")
    with(logger) {
        store("An image")
        store("A text file")
        store("A burger")
    }
}