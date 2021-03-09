package io.personalitygraph.models.relations

import io.personalitygraph.models.nodes.Answer
import io.personalitygraph.models.nodes.Question
import org.neo4j.ogm.annotation.*

@RelationshipEntity(type = "HAS_OPTION")
class HasOption {
    @Id
    @GeneratedValue
    var id: Long? = null

    @StartNode
    var question: Question? = null

    @EndNode
    var answer: Answer? = null
}