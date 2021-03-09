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
class PersonalResult(
    @Relationship(type = "FOR_PERSON") var person: Person,
    @Relationship(type = "FOR_TEST", direction = Relationship.OUTGOING) var test: Test,
    @Relationship(type = "RECEIVED", direction = Relationship.OUTGOING) var results: MutableSet<Result>,
    @Relationship(type = "EXPANDS", direction = Relationship.OUTGOING) var expands: PersonalResult? = null
) {
    @Id
    @GeneratedValue
    var id: Long? = null

    override fun toString(): String {
        return "PersonalResult(id=$id by person=$person for test=$test)"
    }


}