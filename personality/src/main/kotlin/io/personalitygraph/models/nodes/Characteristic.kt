package io.personalitygraph.models.nodes

import io.personalitygraph.models.DomainModel
import org.neo4j.ogm.annotation.GeneratedValue
import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.Property
import org.neo4j.ogm.annotation.Transient

/**
 * example - "IQ"
 * example2 - "Introversion|Extraversion"
 */
@NodeEntity
class Characteristic(@Property var name: String? = "")  : DomainModel() {

    override fun toString(): String {
        return "Characteristic(id=$id, name='$name')"
    }

    @Transient
    data class Builder(
        private var name: String? = null
    ) {
        fun name(name: String) = apply { this.name = name }
        fun build(): Characteristic {
            return Characteristic(name)
        }
    }

}
