package io.personalitygraph.models.nodes

import org.neo4j.ogm.annotation.*

/**
 * example - "IQ test"
 */
@NodeEntity
class Test {
    @Id
    @GeneratedValue
    var id: Long? = null

    @Property
    lateinit var name: String

    @Property
    lateinit var description: String

    @Relationship(type = "CONTAINS", direction = Relationship.OUTGOING)
    var questions: MutableSet<Question> = mutableSetOf()
    @Relationship(type = "ADMITS", direction = Relationship.OUTGOING)
    var possibleResults: MutableSet<Result> = mutableSetOf()
    @Relationship(type = "REQUIRES", direction = Relationship.OUTGOING)
    var requiredResults: MutableSet<Result> = mutableSetOf()
    @Relationship(type = "RESULT_FOR", direction = Relationship.INCOMING)
    var personalResults: MutableSet<PersonalResult> = mutableSetOf()

    lateinit var expandedBy: Set<Test>

    override fun toString(): String {
        return "Test(id=$id, name='$name' expandedBy=${expandedBy.joinToString { it.id.toString() + it.name }})"
    }

}
