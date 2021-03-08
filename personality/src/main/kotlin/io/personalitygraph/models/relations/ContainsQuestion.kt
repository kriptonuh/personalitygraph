package io.personalitygraph.models.relations

import io.personalitygraph.models.nodes.PersonalResult
import io.personalitygraph.models.nodes.Question
import io.personalitygraph.models.nodes.Test
import org.neo4j.ogm.annotation.*

@RelationshipEntity(type = "CONTAINS")
class ContainsQuestion {
    @Id
    @GeneratedValue
    val id: Long = 0

    @StartNode
    lateinit var test: Test

    @EndNode
    lateinit var question: Question
}