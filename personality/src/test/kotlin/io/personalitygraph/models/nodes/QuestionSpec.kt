package io.personalitygraph.models.nodes

import com.nhaarman.mockitokotlin2.mock
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.gherkin.Feature
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

object QuestionSpec : Spek({
    val mockQuestionType = mock<QuestionType>()
    val mockAnswer1 = mock<Answer>()
    val mockAnswer2 = mock<Answer>()

    Feature("Question builder") {
        val builder = Question.Builder()
        Scenario("Simple build") {
            Then("should build complete object"){
                assertNotNull(builder.build())
            }
        }
        Scenario("Build with data filled"){
            val text = "dummytext"
            When("recieved all data"){
                builder
                    .questionText(text)
                    .questionType(mockQuestionType)
                    .applicableAnswers(mockAnswer1, mockAnswer2, mockAnswer1)
            }

            Then("filled with data after build"){
                val result = builder.build()
                assertNotNull(result)
                assertEquals(2, result.answers.size)
                assertEquals(mockQuestionType, result.questionType)
                assertEquals(text, result.questionText)
            }
        }
    }
})
