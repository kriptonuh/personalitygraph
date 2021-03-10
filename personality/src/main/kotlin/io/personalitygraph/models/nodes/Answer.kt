package io.personalitygraph.models.nodes

import io.personalitygraph.models.DomainModel
import io.personalitygraph.models.RelationTypes
import org.neo4j.ogm.annotation.*

/**
 * example - "Yes"
 */
@NodeEntity
class Answer(
    @Property
    var answerText: String? = "",

    @Relationship(type = RelationTypes.AFFECTS, direction = Relationship.OUTGOING)
    var characteristic: Characteristic? = null,

    @Transient var
    affectingValue: Int? = 0

) : DomainModel() {

    override fun toString(): String {
        return "Answer(id=$id, text='$answerText', characteristic=${characteristic})"
    }

    @Transient
    data class Builder(
        private var answerText: String? = null,
        private var characteristic: Characteristic? = null,
        private var value: Int? = null
    ) {
        fun answerText(answerText: String) = apply { this.answerText = answerText }
        fun characteristic(characteristic: Characteristic) = apply { this.characteristic = characteristic }
        fun value(value: Int) = apply { this.value = value }
        fun build(): Answer {
            return Answer(answerText, characteristic, value)
        }
    }
}
