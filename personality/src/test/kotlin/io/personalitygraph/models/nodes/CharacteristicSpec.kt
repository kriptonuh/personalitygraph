package io.personalitygraph.models.nodes

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.gherkin.Feature
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

object CharacteristicSpec : Spek({
    Feature("Characteristic builder") {
        Scenario("building default") {
            val builder by memoized { Characteristic.Builder() }
            val name = "wow"

            When("sent name") {
                builder.name(name)
            }

            Then("should build with name") {
                val result = builder.build()
                assertNotNull(result)
                assertEquals(result.name, name)
            }
        }
    }
})
