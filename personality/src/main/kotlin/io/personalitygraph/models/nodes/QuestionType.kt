package io.personalitygraph.models.nodes

import org.neo4j.ogm.annotation.GeneratedValue
import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.NodeEntity

/**
 * example - "radiobox"
 * example2 - "rate"
 */
@NodeEntity
class QuestionType {

    @Id
    @GeneratedValue
    val id: Long = 0

    lateinit var type: String

    override fun toString(): String {
        return "QuestionType(id=$id, type='$type')"
    }
}
