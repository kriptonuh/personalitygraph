package io.personalitygraph.models.nodes

import com.nhaarman.mockitokotlin2.mock
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.gherkin.Feature
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

object TestSpec : Spek({

    val mockQuestion1 = mock<Question>()
    val mockQuestion2 = mock<Question>()
    val mockQuestion3 = mock<Question>()
    val mockResult1 = mock<Result>()
    val mockResult2 = mock<Result>()
    val mockResult3 = mock<Result>()

    Feature("Test builder") {
        val builder by memoized { Test.Builder() }
        Scenario("Empty build") {
            Then("should create empty item") {
                assertNotNull(builder.build())
            }
        }
        Scenario("Build with data") {
            val text = "dummy"
            When("all data provired") {
                builder
                    .name(text)
                    .description(text)
                    .question(mockQuestion1)
                    .question(mockQuestion2)
                    .question(mockQuestion3)
                    .question(mockQuestion3)
                    .possibleResult(mockResult1)
                    .possibleResult(mockResult2)
                    .requires(mockResult3)
            }
            Then("all data in place") {
                val result = builder.build()
                assertNotNull(result)
                assertEquals(text, result.name)
                assertEquals(text, result.description)
                assertEquals(2, result.possibleResults.size)
                assertEquals(3, result.questions.size)
                assertTrue(result.requiredResults.contains(mockResult3))
            }
        }
    }
})
