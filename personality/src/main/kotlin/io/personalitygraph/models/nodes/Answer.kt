package io.personalitygraph.models.nodes

import org.neo4j.ogm.annotation.GeneratedValue
import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.Relationship

/**
 * example - "Yes"
 */
@NodeEntity
class Answer {
    @Id
    @GeneratedValue
    val id: Long = 0

    lateinit var text: String

    @Relationship(type = "AFFECTS", direction = Relationship.OUTGOING)
    lateinit var characteristic: Characteristic



    override fun toString(): String {
        return "Answer(id=$id, text='$text', characteristic=${characteristic.name})"
    }

}
