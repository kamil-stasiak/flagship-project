package me.stasiak.flagship.examples

import org.amshove.kluent.`should contain`
import org.junit.jupiter.api.Test
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers
import java.sql.DriverManager

@Testcontainers
class TestContainersExamplesTest {
    @Container
    private val pgContainer = PostgreSQLContainer<Nothing>("postgres:14.3")

    @Test
    fun `postgres container return postgres version`() {
        // get the connection
        val connection = DriverManager
            .getConnection(
                pgContainer.jdbcUrl,
                pgContainer.username,
                pgContainer.password
            )

        // prints true if the connection is valid
        println(connection.isValid(0))

        val query = connection.prepareStatement("SELECT version();")

        // the query is executed and results are fetched
        val result = query.executeQuery()
        result.next()


        val versionString = result.getString(1)
        versionString `should contain` "PostgreSQL 14.3"
    }
}
