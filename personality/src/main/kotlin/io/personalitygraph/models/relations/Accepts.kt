package io.personalitygraph.models.relations

import io.personalitygraph.models.nodes.*
import org.neo4j.ogm.annotation.*

@RelationshipEntity(type = "ACCEPTS")
class Accepts {
    @Id
    @GeneratedValue
    var id: Long? = null

    @StartNode
    var firstResult: Result? = null

    @EndNode
    var secondResult: Result? = null
}