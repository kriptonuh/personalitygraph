package io.personalitygraph.models.nodes

import org.neo4j.ogm.annotation.GeneratedValue
import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.Relationship

/**
 * example - "2+2"
 */
@NodeEntity
class Question {

    @Id
    @GeneratedValue
    val id: Long = 0

    lateinit var questionText: String

    @Relationship(type = "OF_TYPE")
    lateinit var questionType: QuestionType

    @Relationship(type = "HAS_OPTIONS", direction = Relationship.OUTGOING)
    lateinit var answers: Set<Answer>

    override fun toString(): String {
        return "Question(id=$id, questionText='$questionText', " +
                "questionType=${questionType.type}, " +
                "answer number=${answers.size})"
    }


}
