package io.personalitygraph.models.nodes

import io.personalitygraph.models.DomainModel
import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.Property

/**
 * example - "radiobox"
 * example2 - "rate"
 */
@NodeEntity
class QuestionType(@Property var type: String? = "") : DomainModel() {

    override fun toString(): String {
        return "QuestionType(id=$id, type='$type')"
    }

    data class Builder(
        private var type: String? = null
    ) {
        fun typeName(typeName: String) = apply { this.type = typeName }
        fun build(): QuestionType {
            return QuestionType(type)
        }


    }
}
