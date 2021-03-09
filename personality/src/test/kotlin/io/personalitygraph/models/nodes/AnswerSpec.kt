package io.personalitygraph.models.nodes

import com.nhaarman.mockitokotlin2.mock
import io.ktor.server.testing.*
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.gherkin.Feature
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

object AnswerSpec : Spek({

    val mockCharacteristic = mock<Characteristic>()

    Feature("Bulding answer"){
        val builder by memoized { Answer.Builder() }
        Scenario("Full data"){
            val answerText = "answer"
            val value = 4
            When("all data added to builder"){
                builder
                    .answerText(answerText)
                    .characteristic(mockCharacteristic)
                    .value(value)
            }
            Then("after build we see all of them"){
                val result = builder.build()
                assertNotNull(result)
                assertEquals(answerText, result.answerText)
                assertEquals(mockCharacteristic, result.characteristic)
                assertEquals(value, result.affectingValue)
            }
        }
    }
})
