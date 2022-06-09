package me.stasiak.flagship.entry.point

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import me.stasiak.flagship.module.user.interfaces.configureUserRouting

fun main() {
    embeddedServer(
        factory = Netty,
        port = 8080,
        host = "0.0.0.0",
        watchPaths = listOf("classes")
    ) {
        configureRouting()
    }.start(wait = true)
}

fun Application.configureRouting() {
    configureUserRouting()
}