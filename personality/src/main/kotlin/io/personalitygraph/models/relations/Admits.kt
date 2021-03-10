package io.personalitygraph.models.relations

import io.personalitygraph.models.RelationTypes
import io.personalitygraph.models.nodes.Result
import io.personalitygraph.models.nodes.Test
import org.neo4j.ogm.annotation.*

@RelationshipEntity(type = RelationTypes.ADMITS)
class Admits {
    @Id
    @GeneratedValue
    var id: Long? = null

    @StartNode
    var test: Test? = null

    @EndNode
    var result: Result? = null
}