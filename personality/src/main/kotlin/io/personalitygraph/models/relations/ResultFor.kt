package io.personalitygraph.models.relations

import io.personalitygraph.models.RelationTypes
import io.personalitygraph.models.nodes.*
import org.neo4j.ogm.annotation.*

@RelationshipEntity(type = RelationTypes.RESULT_FOR)
class ResultFor {
    @Id
    @GeneratedValue
    var id: Long? = null

    @StartNode
    var personalResult: PersonalResult? = null

    @EndNode
    var test: Test? = null
}