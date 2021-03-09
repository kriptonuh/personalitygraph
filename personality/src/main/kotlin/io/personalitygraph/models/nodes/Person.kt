package io.personalitygraph.models.nodes

import io.personalitygraph.models.DomainModel
import org.neo4j.ogm.annotation.*


@NodeEntity(label = "Person")
class Person(
    @Property var name: String?,

    @Relationship(type = "FOR_PERSON", direction = Relationship.INCOMING)
    var personalResults: MutableSet<PersonalResult>
) : DomainModel() {

    @Transient
    data class Builder(
        private var name: String? = null,
        private var personalResults: MutableSet<PersonalResult> = mutableSetOf()
    ) {
        fun name(name: String) = apply { this.name = name }
        fun personalResult(personalResult: PersonalResult) = apply { this.personalResults.add(personalResult) }
        fun personalResults(vararg personalResults: PersonalResult) =
            apply { this.personalResults.addAll(personalResults) }

        fun build(): Person {
            return Person(name, personalResults)
        }
    }

    override fun toString(): String {
        return "Person(id=$id, name='$name', has results: [${personalResults.joinToString()}])"
    }

}