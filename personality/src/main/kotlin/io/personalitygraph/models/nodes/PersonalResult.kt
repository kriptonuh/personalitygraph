package io.personalitygraph.models.nodes

import org.neo4j.ogm.annotation.GeneratedValue
import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.Relationship

/**
 * example - "your IQ = 150"
 * example - "you are Introvert"
 */
@NodeEntity
class PersonalResult {
    @Id
    @GeneratedValue
    val id: Long = 0

    @Relationship(type = "FOR_PERSON", direction = Relationship.OUTGOING)
    lateinit var person: Person

    @Relationship(type = "FOR_TEST", direction = Relationship.OUTGOING)
    lateinit var test: Test

    @Relationship(type = "RECEIVED", direction = Relationship.OUTGOING)
    lateinit var result: Result

    @Relationship(type = "EXPANDS", direction = Relationship.OUTGOING)
    lateinit var expands: PersonalResult

    override fun toString(): String {
        return "PersonalResult(id=$id, test=${test.name}, result=${result.name})"
    }


}