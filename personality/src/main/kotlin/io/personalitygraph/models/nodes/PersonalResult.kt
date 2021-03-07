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

    //lateinit var name: String

    lateinit var test: Test
    //lateinit var characteristic: Characteristic
    lateinit var result: Result

    lateinit var expands: PersonalResult

    override fun toString(): String {
        return "PersonalResult(id=$id, test=${test.name}, result=${result.name})"
    }


}