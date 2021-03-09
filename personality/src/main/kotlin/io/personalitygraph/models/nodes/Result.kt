package io.personalitygraph.models.nodes

import org.neo4j.ogm.annotation.*

/**
 * example - "Passed"
 * example2 - "Introvert"
 */
@NodeEntity
class Result(
    @Property var text: String,
    @Relationship(type = "DESCRIBES", direction = Relationship.OUTGOING)
    var characteristic: Characteristic,
    @Property var min: Int = 0,
    @Property var max: Int = 0,
    @Property var description: String = ""
) {
    @Id
    @GeneratedValue
    var id: Long? = null

    @Relationship(type = "ACCEPTS", direction = Relationship.UNDIRECTED)
    var acceptedResults: MutableSet<Result> = mutableSetOf()

    override fun toString(): String {
        return "Result(id=$id, text='$text', creteria: characteristic=${characteristic} min=$min, max=$max)"
    }


}
