package io.personalitygraph.models.relations

import io.personalitygraph.models.nodes.*
import org.neo4j.ogm.annotation.*

@RelationshipEntity(type = "FOR_PERSON")
class ForPerson {
    @Id
    @GeneratedValue
    val id: Long = 0

    @StartNode
    lateinit var personalResult: PersonalResult

    @EndNode
    lateinit var person: Person
}