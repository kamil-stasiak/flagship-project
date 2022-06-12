package me.stasiak.flagship.examples

import org.amshove.kluent.`should not be`
import org.junit.jupiter.api.Test


class KluentExamplesTest {
//    @Test
    fun `kluent method with space in name works in junit5`() {
        val emptyList = emptyList<String>()

        emptyList `should not be` null
    }
}
