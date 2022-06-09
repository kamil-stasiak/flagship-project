package me.stasiak.flagship.examples

import arrow.core.Either
import arrow.core.Validated
import arrow.core.continuations.EffectScope
import arrow.core.continuations.either
import arrow.core.left
import arrow.core.right
import kotlinx.coroutines.runBlocking
import java.util.UUID

// source: https://github.com/nomisRev/ktor-arrow-webinar-31-05-2022/pull/2/files

typealias UserErrors = EffectScope<UserError>

data class User(val username: String, val email: String)

@JvmInline
value class UserId(val raw: String)

sealed interface DomainError {
    val message: String
}

sealed interface UserError : DomainError
sealed interface EmailError : DomainError

data class UserAlreadyExists(val userId: String) : UserError {
    override val message: String
        get() = "User $userId already exists"
}

data class InvalidEmailFormat(val userId: String) : UserError {
    override val message: String
        get() = "Email $userId is invalid"
}

data class EmailWithoutAt(val email: String) : EmailError {
    override val message: String
        get() = "Email $email does not contain at sign"
}

//
fun validateEmail(user: User): Validated<EmailError, User> {
    return if (user.email.contains("@")) Validated.Valid(user)
    else Validated.Invalid(EmailWithoutAt(user.email))
}


fun insertAndGetId(user: User): Either<UserAlreadyExists, UserId> {
    return if (user.email == "joeDoe@mail.com") UserAlreadyExists(user.email).left()
    else UserId(UUID.randomUUID().toString()).right()
}

object OldSyntax {
    suspend fun insert(user: User): Either<UserError, UserId> = either {
        val validatedUser = validateEmail(user).mapLeft { InvalidEmailFormat(user.email) }.bind()
        insertAndGetId(validatedUser).bind()
    }
}

object NewSyntax {
    context(UserErrors) suspend fun insert(user: User): UserId {
        val validatedUser = validateEmail(user).mapLeft { InvalidEmailFormat(user.email) }.bind()
        return insertAndGetId(validatedUser).bind()
    }
}

fun main() {
    val userAlreadyExist = User(
        username = "JohnDoe",
        email = "joeDoe@mail.com",
    )

    val invalidEmail = User(
        username = "", // empty username
        email = "invalid email",
    )

    val newUser = User(
        username = "exampleNewUser", // empty username
        email = "example@mail.com",
    )

    val result = runBlocking {
        val oldSyntaxAlreadyExist: Either<UserError, UserId> = OldSyntax.insert(userAlreadyExist)
        val oldSyntaxInvalidEmail: Either<UserError, UserId> = OldSyntax.insert(invalidEmail)
        val oldSyntaxNewUser: Either<UserError, UserId> = OldSyntax.insert(newUser)

        val newSyntaxAlreadyExist: Either<UserError, UserId> = either {
            NewSyntax.insert(userAlreadyExist)
        }

        val newSyntaxInvalidEmail: Either<UserError, UserId> = either {
            NewSyntax.insert(invalidEmail)
        }

        val newSyntaxNewUser: Either<UserError, UserId> = either {
            NewSyntax.insert(newUser)
        }

        return@runBlocking mapOf(
            "oldSyntaxAlreadyExist" to oldSyntaxAlreadyExist,
            "oldSyntaxInvalidEmail" to oldSyntaxInvalidEmail,
            "oldSyntaxNewUser" to oldSyntaxNewUser,
            "newSyntaxAlreadyExist" to newSyntaxAlreadyExist,
            "newSyntaxInvalidEmail" to newSyntaxInvalidEmail,
            "newSyntaxNewUser" to newSyntaxNewUser,
        )
    }

    println(result)
}