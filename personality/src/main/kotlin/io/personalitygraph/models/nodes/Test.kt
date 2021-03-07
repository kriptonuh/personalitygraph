package io.personalitygraph.models.nodes

import org.neo4j.ogm.annotation.GeneratedValue
import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.NodeEntity

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

    lateinit var questions: Set<Question>
    lateinit var possibleResults: Set<Result>
    lateinit var requiredResults: Set<Result>

    lateinit var expandedBy: Set<Test>

    override fun toString(): String {
        return "Test(id=$id, name='$name' expandedBy=${expandedBy.joinToString { it.id.toString() + it.name }})"
    }

}
