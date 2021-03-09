package io.personalitygraph.models.nodes

import org.neo4j.ogm.annotation.*

/**
 * example - "2+2"
 */
@NodeEntity
class Question {

    @Id
    @GeneratedValue
    var id: Long? = null

    @Property
    var questionText: String? = null

    @Relationship(type = "OF_TYPE")
    var questionType: QuestionType? = null

    @Relationship(type = "HAS_OPTIONS", direction = Relationship.OUTGOING)
    var answers: MutableSet<Answer> = mutableSetOf()

    override fun toString(): String {
        return "Question(id=$id, questionText='$questionText', " +
                "questionType=${questionType}, " +
                "answer number=${answers.size})"
    }


}
