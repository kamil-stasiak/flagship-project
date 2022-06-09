package me.stasiak.flagship.module.user.interfaces

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import me.stasiak.flagship.module.user.application.UserService

fun Application.configureUserRouting() {
    routing {
        route("/users") {
            get {
                call.respondText("All users!")
            }
            get("/{login}") {
                val login: String = call.parameters["login"] ?: "emptyLogin"
                val cratedLogin = UserService().createUser(login)
                call.respondText("Single user: $cratedLogin")
            }
        }
    }
}