package me.stasiak.flagship.module.article.interfaces

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.configureArticleRouting() {
    route("/articles") {
        get {
            call.respondText("List Articles")
        }
        get("/feed") {
            call.respondText("Feed Articles")
        }
        get("/{slug}") {
            call.respondText("Get Article")
        }
        post {
            call.respondText("Create Article")
        }
        put("/{slug}") {
            call.respondText("Update Article")
        }
        delete("/{slug}") {
            call.respondText("Delete Article")
        }
        post("/{slug}/comments") {
            call.respondText("Add Comments to an Article")
        }
        get("/{slug}/comments") {
            call.respondText("Get Comments from an Article")
        }
        delete("/{slug}/comments/{id}") {
            call.respondText("Delete Comment")
        }
        post("/{slug}/favorite") {
            call.respondText("Favorite Article")
        }
        delete("/{slug}/favorite") {
            call.respondText("Unfavorite Article")
        }
    }
    route("/tags") {
        get {
            call.respondText("Get Tags")
        }
    }
}
