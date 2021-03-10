package io.personalitygraph.models.relations

import io.personalitygraph.models.RelationTypes
import io.personalitygraph.models.nodes.Question
import io.personalitygraph.models.nodes.Test
import org.neo4j.ogm.annotation.*

@RelationshipEntity(type = RelationTypes.CONTAINS_QUESTION)
class ContainsQuestion {
    @Id
    @GeneratedValue
    var id: Long? = null

    @StartNode
    var test: Test? = null

    @EndNode
    var question: Question? = null
}