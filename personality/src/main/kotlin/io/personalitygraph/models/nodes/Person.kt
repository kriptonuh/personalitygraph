package io.personalitygraph.models.nodes

import org.neo4j.ogm.annotation.*


@NodeEntity(label = "Person")
class Person {
    @Id
    @GeneratedValue
    var id: Long? = null

    @Property
    var name: String? = null

    @Relationship(type = "FOR_PERSON", direction = Relationship.INCOMING)
    var personalResults: MutableSet<PersonalResult> = mutableSetOf()

    fun addResult(personalResult: PersonalResult){
        personalResults.add(personalResult)
    }

    override fun toString(): String {
        return "Person(id=$id, name='$name', has results: [${personalResults.joinToString()}])"
    }

}