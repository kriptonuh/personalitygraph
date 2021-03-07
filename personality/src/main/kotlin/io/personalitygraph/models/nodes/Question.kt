package io.personalitygraph.models.nodes

import org.neo4j.ogm.annotation.GeneratedValue
import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.NodeEntity

/**
 * example - "2+2"
 */
@NodeEntity
class Question {

    @Id
    @GeneratedValue
    val id: Long = 0

    lateinit var questionText: String
    lateinit var questionType: QuestionType

    lateinit var answers: Set<Answer>

    override fun toString(): String {
        return "Question(id=$id, questionText='$questionText', questionType=${questionType.type})"
    }


}
