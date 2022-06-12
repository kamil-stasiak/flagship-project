package me.stasiak.flagship.entry.point


import io.ktor.server.netty.Netty
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import kotlinx.serialization.json.Json
import me.stasiak.flagship.module.article.interfaces.configureArticleRouting
import me.stasiak.flagship.module.profile.interfaces.configureProfileRouting
import me.stasiak.flagship.module.user.interfaces.configureUserRouting
import io.ktor.server.routing.routing
import io.ktor.server.routing.route
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.install
import io.ktor.server.application.Application
import io.ktor.server.engine.embeddedServer

fun main() {
    embeddedServer(
        factory = Netty,
        port = 8080,
        host = "0.0.0.0",
        watchPaths = listOf("classes")
    ) {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
            })
        }
        configureRouting()
    }.start(wait = true)
}

fun Application.configureRouting() {
    routing {
        route("/api") {
            configureUserRouting()
            configureProfileRouting()
            configureArticleRouting()
        }
    }
}
