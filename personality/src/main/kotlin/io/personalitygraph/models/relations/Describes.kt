package io.personalitygraph.models.relations

import io.personalitygraph.models.nodes.Characteristic
import io.personalitygraph.models.nodes.Result
import org.neo4j.ogm.annotation.*

@RelationshipEntity(type = "DESCRIBES")
class Describes {
    @Id
    @GeneratedValue
    val id: Long = 0

    @StartNode
    lateinit var result: Result

    @EndNode
    lateinit var characteristic: Characteristic
}