package io.personalitygraph.models.relations

import io.personalitygraph.models.DomainModel
import io.personalitygraph.models.RelationTypes
import io.personalitygraph.models.nodes.Answer
import io.personalitygraph.models.nodes.Characteristic
import org.neo4j.ogm.annotation.*

@RelationshipEntity(type = RelationTypes.AFFECTS)
class Affects(
    @StartNode var answer: Answer?,
    @EndNode var characteristic: Characteristic?,
    @Property var modifier: Int?
) : DomainModel() {

    @Transient
    data class Builder(
        var answer: Answer? = null,
        var characteristic: Characteristic? = null,
        var modifier: Int? = null
    ) {
        fun answer(answer: Answer) = apply { this.answer = answer }
        fun characteristic(characteristic: Characteristic) = apply { this.characteristic = characteristic }
        fun modifier(modifier: Int) = apply { this.modifier = modifier }
        fun build(): Affects {
            return Affects(answer, characteristic, modifier)
        }
    }

    override fun toString(): String {
        return "Affects(answer=$answer, characteristic=$characteristic, modifier=$modifier)"
    }

}