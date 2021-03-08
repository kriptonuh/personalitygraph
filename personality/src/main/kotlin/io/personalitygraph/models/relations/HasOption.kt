package io.personalitygraph.models.relations

import io.personalitygraph.models.nodes.Answer
import io.personalitygraph.models.nodes.Question
import org.neo4j.ogm.annotation.*

@RelationshipEntity(type = "HAS_OPTION")
class HasOption {
    @Id
    @GeneratedValue
    val id: Long = 0

    @StartNode
    lateinit var question: Question

    @EndNode
    lateinit var answer: Answer
}