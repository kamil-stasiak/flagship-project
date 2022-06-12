package me.stasiak.flagship.common.ktor

import arrow.core.Either
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.util.pipeline.*

// source: https://github.com/nomisRev/ktor-arrow-example/blob/main/src/main/kotlin/io/github/nomisrev/routes/users.kt
// TODO improve how we receive models with validation
private suspend inline fun <reified A : Any> PipelineContext<Unit, ApplicationCall>.receiveCatching(): Either<IllegalStateException, A> =
    Either.catch { call.receive<A>() }.mapLeft { e ->
        IllegalStateException(e.message ?: "Received malformed JSON for ${A::class.simpleName}", e)
    }