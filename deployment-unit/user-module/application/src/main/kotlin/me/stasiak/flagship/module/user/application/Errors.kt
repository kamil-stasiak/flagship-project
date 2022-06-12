package me.stasiak.flagship.module.user.application

import me.stasiak.flagship.common2.error.DomainError

sealed interface UserModulesError : DomainError

object MessageTooShort : UserModulesError {
    override val message: String = "Message too short"
}

object MessageTooLong : UserModulesError {
    override val message: String = "Message too short"
}