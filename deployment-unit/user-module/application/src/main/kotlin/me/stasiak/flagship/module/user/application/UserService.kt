package me.stasiak.flagship.module.user.application

import me.stasiak.flagship.module.user.domain.User

class UserService {
    fun createUser(login: String): String {
        return User(login).login
    }
}