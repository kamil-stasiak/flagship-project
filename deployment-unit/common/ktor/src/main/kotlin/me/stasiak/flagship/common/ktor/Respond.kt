package me.stasiak.flagship.common.ktor

import arrow.core.Either
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*

suspend inline fun <reified T : Any> ApplicationCall.respond(
    result: Either<ErrorWithCode, T>,
    status: HttpStatusCode = HttpStatusCode.OK
) {
    when (result) {
        is Either.Left -> respond(message = result.value.error, status = result.value.code)
        is Either.Right -> respond(message = result.value, status = status)
    }
}