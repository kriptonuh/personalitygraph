package io.personalitygraph.models.nodes

import org.neo4j.ogm.annotation.GeneratedValue
import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.NodeEntity

/**
 * example - "IQ+4"
 */
@NodeEntity
class Answer {
    @Id
    @GeneratedValue
    val id: Long = 0

    lateinit var text: String

    lateinit var characteristic: Characteristic

    //:TODO move to relation
    var value: Int = 0


    override fun toString(): String {
        return "Answer(id=$id, text='$text', characteristic=${characteristic.name}, value+=$value)"
    }

}
