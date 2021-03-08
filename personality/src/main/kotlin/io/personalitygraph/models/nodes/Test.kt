package io.personalitygraph.models.nodes

import org.neo4j.ogm.annotation.GeneratedValue
import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.Relationship

/**
 * example - "IQ test"
 */
@NodeEntity
class Test {
    @Id
    @GeneratedValue
    val id: Long = 0

    lateinit var name: String
    lateinit var description: String

    @Relationship(type = "CONTAINS", direction = Relationship.OUTGOING)
    lateinit var questions: Set<Question>
    @Relationship(type = "ADMITS", direction = Relationship.OUTGOING)
    lateinit var possibleResults: Set<Result>
    @Relationship(type = "REQUIRES", direction = Relationship.OUTGOING)
    lateinit var requiredResults: Set<Result>
    @Relationship(type = "RESULT_FOR", direction = Relationship.INCOMING)
    lateinit var personalResults: Set<PersonalResult>

    lateinit var expandedBy: Set<Test>

    override fun toString(): String {
        return "Test(id=$id, name='$name' expandedBy=${expandedBy.joinToString { it.id.toString() + it.name }})"
    }

}
