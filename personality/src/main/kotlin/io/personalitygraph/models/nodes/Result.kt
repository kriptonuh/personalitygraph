package io.personalitygraph.models.nodes

import org.neo4j.ogm.annotation.*

/**
 * example - "Passed"
 * example2 - "Introvert"
 */
@NodeEntity
class Result {
    @Id
    @GeneratedValue
    var id: Long? = null

    @Property
    var name: String? = null

    @Property
    var description: String? = null

    @Relationship(type = "DESCRIBES", direction = Relationship.OUTGOING)
    var characteristic: Characteristic? = null

    @Relationship(type = "ACCEPTS", direction = Relationship.UNDIRECTED)
    var acceptedResults: MutableSet<Result> = mutableSetOf()

    var min: Int = 0
    var max: Int = 0

    override fun toString(): String {
        return "Result(id=$id, name='$name', creteria: characteristic=${characteristic} min=$min, max=$max)"
    }


}
