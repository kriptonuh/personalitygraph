package io.personalitygraph.models.relations

import io.personalitygraph.models.nodes.*
import org.neo4j.ogm.annotation.*

@RelationshipEntity(type = "OF_TYPE")
class OfType {
    @Id
    @GeneratedValue
    val id: Long = 0

    @StartNode
    lateinit var question: Question

    @EndNode
    lateinit var questionType: QuestionType
}