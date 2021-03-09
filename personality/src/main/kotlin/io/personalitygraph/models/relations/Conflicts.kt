package io.personalitygraph.models.relations

import io.personalitygraph.models.nodes.*
import org.neo4j.ogm.annotation.*

@RelationshipEntity(type = "CONFLICTS")
class Conflicts {
    @Id
    @GeneratedValue
    var id: Long? = null

    @StartNode
    var firstResult: Result? = null

    @EndNode
    var secondResult: Result? = null
}