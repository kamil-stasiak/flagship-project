package me.stasiak.flagship.examples

import com.example.db.ExampleDatabase
import com.squareup.sqldelight.Query
import com.squareup.sqldelight.sqlite.driver.asJdbcDriver
import com.zaxxer.hikari.HikariDataSource
import me.stasiak.db.Users
import org.amshove.kluent.`should contain`
import org.junit.jupiter.api.Test
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers
import java.sql.DriverManager
import java.util.*

//@Testcontainers
class SqlDelightExamplesTest {
//    @Container
    private val pgContainer = PostgreSQLContainer<Nothing>("postgres:14.3")

//    @Test
    fun `postgres container return postgres version`() {
        val dataSource = HikariDataSource().apply {
            username = pgContainer.username
            password = pgContainer.password
            jdbcUrl = pgContainer.jdbcUrl
        }

        val usersDb = ExampleDatabase(dataSource.asJdbcDriver())
        usersDb.abcQueries.createTable()

        val username = UUID.randomUUID().toString().take(10)
        val user = Users(
            id = UUID.randomUUID().toString(),
            username = username,
            email = "$username@stasiak.me"
        )
        val abc: Unit = usersDb.abcQueries.insertObject(user)
        val selectAll: List<Users> = usersDb.abcQueries.selectAll().executeAsList()

        println(selectAll)
    }
}
