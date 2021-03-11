package io.personalitygraph.models.nodes

import io.personalitygraph.models.DomainModel
import io.personalitygraph.models.RelationTypes
import org.neo4j.ogm.annotation.*

/**
 * example - "Passed"
 * example2 - "Introvert"
 */
@NodeEntity
class Result(
    @Property var text: String? = "",
    @Property var description: String? = "",
    @Property var min: Int = 0,
    @Property var max: Int = 0,
    @Relationship(type = RelationTypes.DESCRIBES, direction = Relationship.OUTGOING)
    var characteristic: Characteristic? = null,
    @Relationship(type = RelationTypes.CONFLICTS, direction = Relationship.UNDIRECTED)
    var conflictingResults: MutableSet<Result> = mutableSetOf(),
    @Relationship(type = RelationTypes.ACCEPTS, direction = Relationship.UNDIRECTED)
    var acceptedResults: MutableSet<Result> = mutableSetOf()
) : DomainModel() {


    override fun toString(): String {
        return "Result(id=$id, text='$text', creteria: characteristic=${characteristic} min=$min, max=$max)"
    }

    data class Builder(
        private var text: String? = "",
        private var description: String? = "",
        private var min: Int = 0,
        private var max: Int = 0,
        private var characteristic: Characteristic? = null,
        private var acceptedResults: MutableSet<Result> = mutableSetOf(),
        private var conflictingResults: MutableSet<Result> = mutableSetOf()
    ) {
        fun resultText(text: String) = apply { this.text = text }
        fun valueInterval(min: Int, max: Int) = apply {
            this.min = min
            this.max = max
        }

        fun resultDescription(text: String) = apply { this.description = text }
        fun describesCharacteristic(chr: Characteristic) = apply { this.characteristic = chr }
        fun conflictsWith(result: Result) = apply { conflictingResults.add(result) }
        fun goesWellWith(result: Result) = apply { acceptedResults.add(result) }


        fun build(): Result {
            return Result(text, description, min, max, characteristic, conflictingResults, acceptedResults)
        }
    }
}


