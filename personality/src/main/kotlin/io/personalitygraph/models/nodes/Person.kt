package io.personalitygraph.models.nodes

import org.neo4j.ogm.annotation.*


@NodeEntity(label = "Person")
class Person(
    @Property var name: String
) {
    @Id
    @GeneratedValue
    var id: Long? = null

    @Relationship(type = "FOR_PERSON", direction = Relationship.INCOMING)
    var personalResults: MutableSet<PersonalResult> = mutableSetOf()

    override fun toString(): String {
        return "Person(id=$id, name='$name', has results: [${personalResults.joinToString()}])"
    }

}