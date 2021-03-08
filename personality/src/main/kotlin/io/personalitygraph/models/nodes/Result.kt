package io.personalitygraph.models.nodes

import org.neo4j.ogm.annotation.GeneratedValue
import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.Relationship

/**
 * example - "Passed"
 * example2 - "Introvert"
 */
@NodeEntity
class Result {
    @Id
    @GeneratedValue
    val id: Long = 0

    lateinit var name: String
    lateinit var description: String

    @Relationship(type = "DESCRIBES", direction = Relationship.OUTGOING)
    lateinit var characteristic: Characteristic

    @Relationship(type = "ACCEPTS", direction = Relationship.UNDIRECTED)
    lateinit var acceptedResults: Set<Result>

    var min: Int = 0
    var max: Int = 0

    override fun toString(): String {
        return "Result(id=$id, name='$name', creteria: characteristic=${characteristic.name} min=$min, max=$max)"
    }


}
