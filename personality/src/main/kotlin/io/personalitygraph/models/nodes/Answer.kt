package io.personalitygraph.models.nodes

import org.neo4j.ogm.annotation.*

/**
 * example - "Yes"
 */
@NodeEntity
class Answer(
    @Property var text: String
) {

    @Id
    @GeneratedValue
    var id: Long? = null

    @Relationship(type = "AFFECTS", direction = Relationship.OUTGOING)
    var characteristic: Characteristic? = null

    override fun toString(): String {
        return "Answer(id=$id, text='$text', characteristic=${characteristic})"
    }

}
