package io.personalitygraph.models.nodes

import org.junit.jupiter.api.Assertions.assertNotNull
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.gherkin.Feature
import kotlin.test.assertEquals
import kotlin.test.assertNull

object PersonSpec : Spek({
    Feature("Person builder") {
        val builder by memoized { Person.Builder() }

        Scenario("Sending normal name") {
            val name = "TestName"
            When("name sent") {
                builder.name(name)
            }
            Then("name should be in place after build") {
                assertEquals(builder.build().name, name)
            }
        }

        Scenario("Do not sending name") {
            Then("should set nothing") {
                val person = builder.build()
                assertNotNull(person)
                assertNull(person.name)

            }
        }
        Scenario("Do not set personalResults") {
            Then("should set nothing, but create emptySet") {
                val person = builder.build()
                assertNotNull(person)
                assertNotNull(person.personalResults)
                assertEquals(person.personalResults.size, 0)

            }
        }
    }
})