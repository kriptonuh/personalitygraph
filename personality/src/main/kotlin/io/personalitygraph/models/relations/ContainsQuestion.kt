package io.personalitygraph.models.relations

import io.personalitygraph.models.nodes.PersonalResult
import io.personalitygraph.models.nodes.Question
import io.personalitygraph.models.nodes.Test
import org.neo4j.ogm.annotation.*

@RelationshipEntity(type = "CONTAINS")
class ContainsQuestion {
    @Id
    @GeneratedValue
    var id: Long? = null

    @StartNode
    var test: Test? = null

    @EndNode
    var question: Question? = null
}