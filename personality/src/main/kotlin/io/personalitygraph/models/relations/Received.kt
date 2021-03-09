package io.personalitygraph.models.relations

import io.personalitygraph.models.nodes.*
import org.neo4j.ogm.annotation.*

@RelationshipEntity(type = "RECEIVED")
class Received {
    @Id
    @GeneratedValue
    var id: Long? = null

    @StartNode
    var personalResult: PersonalResult? = null

    @EndNode
    var result: Result? = null
}