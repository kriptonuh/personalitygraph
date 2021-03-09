package io.personalitygraph.models.nodes

import org.neo4j.ogm.annotation.GeneratedValue
import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.Relationship

/**
 * example - "your IQ = 150"
 * example - "you are Introvert"
 */
@NodeEntity(label = "PersonalResult")
class PersonalResult {
    @Id
    @GeneratedValue
    var id: Long? = null

    @Relationship(type = "FOR_PERSON")
    var person: Person? = null

    @Relationship(type = "FOR_TEST", direction = Relationship.OUTGOING)
    var test: Test? = null

    @Relationship(type = "RECEIVED", direction = Relationship.OUTGOING)
    var results: MutableSet<Result> = mutableSetOf()

    @Relationship(type = "EXPANDS", direction = Relationship.OUTGOING)
    var expands: PersonalResult? = null

    override fun toString(): String {
        return "PersonalResult(id=$id by person=$person for test=$test)"
    }


}