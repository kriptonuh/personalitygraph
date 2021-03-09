package io.personalitygraph.models.nodes

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.gherkin.Feature
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

object PersonalResultSpec : Spek({
    val mockResult = mock<Result> {
        on { id } doReturn 1
    }
    val mockPerson = mock<Person> {
        on { id } doReturn 2
    }
    val mockTest = mock<Test> {
        on { id } doReturn 3
    }

    Feature("PersonalResult builder") {
        val builder by memoized { PersonalResult.Builder() }
        Scenario("Empty build") {
            Then("shoould create empty PersonalResult") {
                assertNotNull(builder.build())
            }
        }
        Scenario("Build with data filled") {
            When("all data sent") {
                builder
                    .person(mockPerson)
                    .expands(builder.build())
                    .result(mockResult)
                    .forTest(mockTest)
            }
            Then("should build complete object") {
                val result = builder.build()
                assertNotNull(result)
                assertEquals(3, result.test?.id)
                assertEquals(2, result.person?.id)
                assertEquals(1, result.results.size)
                assertTrue(result.results.contains(mockResult))
            }
        }
    }
})
