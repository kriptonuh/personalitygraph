package io.personalitygraph.models.relations

import io.personalitygraph.models.nodes.*
import org.neo4j.ogm.annotation.*

@RelationshipEntity(type = "RECEIVED")
class Received {
    @Id
    @GeneratedValue
    val id: Long = 0

    @StartNode
    lateinit var personalResult: PersonalResult

    @EndNode
    lateinit var result: Result
}