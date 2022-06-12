package me.stasiak.flagship.module.user.application

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import me.stasiak.flagship.module.user.domain.User

class UserService {
    fun createUser(login: String): String {
        return User(login).login
    }
}

fun messageCreator(message: String): Either<UserModulesError, String> {
    if (message.length < 4) return MessageTooShort.left()
    if (message.length > 20) return MessageTooLong.left()

    return message.right()
}