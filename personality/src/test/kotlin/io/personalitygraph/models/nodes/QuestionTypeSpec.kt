package io.personalitygraph.models.nodes

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.gherkin.Feature
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

object QuestionTypeSpec : Spek({
    Feature("QuestionType builder") {
        val builder = QuestionType.Builder()
        Scenario("Empty build") {
            Then("should create empty item"){
                assertNotNull(builder.build())
            }
        }
        Scenario("With data filled"){
            val dummyName = "frefr"
            When("parameters added"){
                builder.typeName(dummyName)
            }
            Then("parameters should appear after build"){
                val result = builder.build()
                assertNotNull(result)
                assertEquals(dummyName, result.type)
            }
        }
    }
})
