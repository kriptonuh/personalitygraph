package io.personalitygraph.models.nodes

import org.neo4j.ogm.annotation.GeneratedValue
import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.Property

/**
 * example - "IQ"
 * example2 - "Introversion|Extraversion"
 */
@NodeEntity
class Characteristic(@Property var name: String) {
    @Id
    @GeneratedValue
    var id: Long? = null

    override fun toString(): String {
        return "Characteristic(id=$id, name='$name')"
    }


}
