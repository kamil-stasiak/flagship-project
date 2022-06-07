package me.stasiak.flagship.list

import net.jqwik.api.ForAll
import net.jqwik.api.Property
import org.amshove.kluent.`should contain all`


class PBTExamplesTest {

    @Property
    fun `reversing keeps all elements`(@ForAll list: List<Int>) {
        val reversed = list.reversed()
        reversed `should contain all` list
    }
}
