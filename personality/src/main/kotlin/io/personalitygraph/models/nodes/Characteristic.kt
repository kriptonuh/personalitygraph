package io.personalitygraph.models.nodes

import org.neo4j.ogm.annotation.GeneratedValue
import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.NodeEntity

/**
 * example - "IQ"
 * example2 - "Introversion|Extraversion"
 */
@NodeEntity
class Characteristic {
    @Id
    @GeneratedValue
    val id: Long = 0

    lateinit var name: String

    override fun toString(): String {
        return "Characteristic(id=$id, name='$name')"
    }


}
