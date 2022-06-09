package me.stasiak.flagship.module.user.domain

import java.util.*

class User(login: String) {
    val login = login.lowercase(Locale.getDefault())
}