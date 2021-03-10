package io.personalitygraph.models.nodes

import io.personalitygraph.models.DomainModel
import io.personalitygraph.models.RelationTypes
import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.Relationship

/**
 * example - "your IQ = 150"
 * example - "you are Introvert"
 */
@NodeEntity(label = "PersonalResult")
class PersonalResult(
    @Relationship(type = RelationTypes.FOR_PERSON) var person: Person? = null,
    @Relationship(type = RelationTypes.FOR_TEST, direction = Relationship.OUTGOING) var test: Test? = null,
    @Relationship(type = RelationTypes.EXPANDS, direction = Relationship.OUTGOING) var expands: PersonalResult? = null,
    @Relationship(type = RelationTypes.RECEIVED, direction = Relationship.OUTGOING)
    var results: MutableSet<Result> = mutableSetOf()
) : DomainModel() {

    override fun toString(): String {
        return "PersonalResult(id=$id by person=$person for test=$test)"
    }

    data class Builder(
        private var person: Person? = null,
        private var test: Test? = null,
        private var results: MutableSet<Result> = mutableSetOf(),
        private var expands: PersonalResult? = null

    ) {
        fun person(person: Person) = apply { this.person = person }
        fun forTest(test: Test) = apply { this.test = test }
        fun result(result: Result) = apply { this.results.add(result) }
        fun expands(personalResult: PersonalResult) = apply { this.expands = personalResult }
        fun build(): PersonalResult {
            return PersonalResult(person, test, expands, results)
        }
    }
}