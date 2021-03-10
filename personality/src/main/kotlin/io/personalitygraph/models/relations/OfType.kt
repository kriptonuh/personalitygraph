package io.personalitygraph.models.relations

import io.personalitygraph.models.RelationTypes
import io.personalitygraph.models.nodes.*
import org.neo4j.ogm.annotation.*

@RelationshipEntity(type = RelationTypes.OF_TYPE)
class OfType {
    @Id
    @GeneratedValue
    var id: Long? = null

    @StartNode
    var question: Question? = null

    @EndNode
    var questionType: QuestionType? = null
}