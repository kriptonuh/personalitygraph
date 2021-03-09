package io.personalitygraph.models.nodes

import org.neo4j.ogm.annotation.*

/**
 * example - "2+2"
 */
@NodeEntity
class Question(
    @Property var questionText: String,
    @Relationship(type = "OF_TYPE") var questionType: QuestionType
) {

    @Id
    @GeneratedValue
    var id: Long? = null

    @Relationship(type = "HAS_OPTIONS", direction = Relationship.OUTGOING)
    var answers: MutableSet<Answer> = mutableSetOf()

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

}
