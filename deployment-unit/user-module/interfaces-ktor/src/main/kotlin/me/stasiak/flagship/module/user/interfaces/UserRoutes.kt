package me.stasiak.flagship.module.user.interfaces

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import me.stasiak.flagship.common.ktor.respond
import me.stasiak.flagship.module.user.application.UserService
import me.stasiak.flagship.module.user.application.messageCreator

fun Route.configureUserRouting() {
    route("/users") {
        post("/login") {
            call.respondText("Authentication")
        }
        post {
            call.respondText("Registration")
        }
    }
    route("/user") {
        get {
            call.respondText("Get Current User")
        }
        put {
            call.respondText("Update User")
        }
    }
    // todo delete
    route("/example") {
        get("/{login}") {
            val login: String = call.parameters["login"] ?: "emptyLogin"
            val cratedLogin = UserService().createUser(login)
            call.respondText("Single user: $cratedLogin")
        }
    }
    route("/arrow") {
        get("/{message}") {
            val message: String = call.parameters["message"] ?: ""

            call.respond<String>(result = messageCreator(message).mapErrors())
        }
    }
}
