package io.personalitygraph.models.relations

import io.personalitygraph.models.nodes.*
import org.neo4j.ogm.annotation.*

@RelationshipEntity(type = "ORTHOGONAL")
class Orthogonal {
    @Id
    @GeneratedValue
    val id: Long = 0

    @StartNode
    lateinit var firstResult: Result

    @EndNode
    lateinit var secondResult: Result
}