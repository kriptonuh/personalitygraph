package io.personalitygraph.models.relations

import io.personalitygraph.models.nodes.Result
import io.personalitygraph.models.nodes.Test
import org.neo4j.ogm.annotation.*

@RelationshipEntity(type = "ADMITS")
class Admits {
    @Id
    @GeneratedValue
    val id: Long = 0

    @StartNode
    lateinit var test: Test

    @EndNode
    lateinit var result: Result
}