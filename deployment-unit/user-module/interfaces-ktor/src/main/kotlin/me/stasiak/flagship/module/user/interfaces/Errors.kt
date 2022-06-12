package me.stasiak.flagship.module.user.interfaces

import arrow.core.Either
import io.ktor.http.HttpStatusCode.Companion.OK
import me.stasiak.flagship.common.ktor.ApiError
import me.stasiak.flagship.common.ktor.ErrorWithCode
import me.stasiak.flagship.module.user.application.MessageTooLong
import me.stasiak.flagship.module.user.application.MessageTooShort
import me.stasiak.flagship.module.user.application.UserModulesError

internal fun <T> Either<UserModulesError, T>.mapErrors(): Either<ErrorWithCode, T> =
    this.mapLeft {
        val error = ApiError(ApiError.Errors(listOf(it.message)))

        when (it) {
            is MessageTooLong -> ErrorWithCode(error = error, code = OK)
            is MessageTooShort -> ErrorWithCode(error = error, code = OK)
        }
    }

