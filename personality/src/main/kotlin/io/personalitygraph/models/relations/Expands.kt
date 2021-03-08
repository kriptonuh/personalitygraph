package io.personalitygraph.models.relations

import io.personalitygraph.models.nodes.PersonalResult
import org.neo4j.ogm.annotation.*

@RelationshipEntity(type = "EXPANDS")
class Expands {
    @Id
    @GeneratedValue
    val id: Long = 0

    @StartNode
    lateinit var current: PersonalResult

    @EndNode
    lateinit var parent: PersonalResult
}