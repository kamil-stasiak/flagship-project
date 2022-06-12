package me.stasiak.flagship.common.ktor

import kotlinx.serialization.Serializable
import io.ktor.http.HttpStatusCode

data class ErrorWithCode(
    val error: ApiError,
    val code: HttpStatusCode,
)

@Serializable
data class ApiError(
    val errors: Errors
) {
    @Serializable
    data class Errors(
        val body: List<String>
    )
}
