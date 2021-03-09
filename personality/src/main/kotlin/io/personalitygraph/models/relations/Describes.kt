package io.personalitygraph.models.relations

import io.personalitygraph.models.nodes.Characteristic
import io.personalitygraph.models.nodes.Result
import org.neo4j.ogm.annotation.*

@RelationshipEntity(type = "DESCRIBES")
class Describes {
    @Id
    @GeneratedValue
    var id: Long? = null

    @StartNode
    var result: Result? = null

    @EndNode
    var characteristic: Characteristic? = null
}