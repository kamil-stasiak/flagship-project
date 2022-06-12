package me.stasiak.flagship.module.profile.interfaces

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.configureProfileRouting() {
    route("/profiles") {
        get("/{username}") {
            val login: String = call.parameters["username"] ?: "emptyLogin" // todo get string or return error
            call.respondText("Get Profile: $login")
        }
        post("/{username}/follow") {
            val login: String = call.parameters["username"] ?: "emptyLogin" // todo get string or return error
            call.respondText("Follow user: $login")
        }
        delete("/{username}/follow") {
            val login: String = call.parameters["username"] ?: "emptyLogin" // todo get string or return error
            call.respondText("Unfollow user: $login")
        }
    }
}
