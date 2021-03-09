package io.personalitygraph.models.nodes

import com.nhaarman.mockitokotlin2.mock
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.gherkin.Feature
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

object ResultSpec : Spek({
    val mockCharacteristic = mock<Characteristic>()
    val mockResult1 = mock<Result>()
    val mockResult2 = mock<Result>()

    Feature("Result builder") {
        val builder = Result.Builder()
        Scenario("Empty build") {
            Then("should create empty item") {
                assertNotNull(builder.build())
            }
        }
        Scenario("Build with data filled") {
            val text = "dummyText"
            val min = 0
            val max = 10
            When("all data recieved") {
                builder
                    .resultText(text)
                    .valueInterval(min, max)
                    .resultDescription(text)
                    .describesCharacteristic(mockCharacteristic)
                    .conflictsWith(mockResult1)
                    .goesWellWith(mockResult2)
            }
            Then("all data populated with build"){
                val result = builder.build()
                assertNotNull(result)
                assertEquals(text, result.text)
                assertEquals(text, result.description)
                assertEquals(1, result.conflictingResults.size)
                assertEquals(1, result.acceptedResults.size)
                assertEquals(0, result.min)
                assertEquals(10, result.max)
            }
        }
    }
})
