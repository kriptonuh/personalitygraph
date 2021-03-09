package io.personalitygraph.models.nodes

import io.personalitygraph.models.DomainModel
import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.Property
import org.neo4j.ogm.annotation.Relationship

/**
 * example - "2+2"
 */
@NodeEntity
class Question(
    @Property var questionText: String? = "",
    @Relationship(type = "OF_TYPE") var questionType: QuestionType? = null,
    @Relationship(type = "HAS_OPTIONS", direction = Relationship.OUTGOING)
    var answers: MutableSet<Answer> = mutableSetOf()
) : DomainModel() {

    override fun toString(): String {
        return "Question(id=$id, questionText='$questionText', " +
                "questionType=${questionType}, " +
                "answer number=${answers.size})"
    }


    fun addAnswer(answer: Answer) {
        answers.add(answer)
    }

    fun addAnswers(vararg newAnswers: Answer) {
        answers.addAll(newAnswers)
    }

    fun addAnswers(newAnswers: Collection<Answer>) {
        answers.addAll(newAnswers)
    }

    data class Builder(
        private var questionText: String? = null,
        private var questionType: QuestionType? = null,
        private var answers: MutableSet<Answer> = mutableSetOf()
    ) {
        fun questionText(text: String) = apply { this.questionText = text }
        fun questionType(questionType: QuestionType?) = apply { this.questionType = questionType }
        fun applicableAnswer(answer: Answer) = apply { this.answers.add(answer) }
        fun applicableAnswers(vararg answer: Answer) = apply { this.answers.addAll(answer) }
        fun build(): Question {
            return Question(questionText, questionType, answers)
        }
    }

}
