package io.personalitygraph.models.nodes

import org.neo4j.ogm.annotation.GeneratedValue
import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.Property

/**
 * example - "radiobox"
 * example2 - "rate"
 */
@NodeEntity
class QuestionType(
    @Property var type: String
) {

    @Id
    @GeneratedValue
    var id: Long? = null

    override fun toString(): String {
        return "QuestionType(id=$id, type='$type')"
    }
}
