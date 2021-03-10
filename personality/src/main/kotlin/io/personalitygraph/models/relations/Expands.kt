package io.personalitygraph.models.relations

import io.personalitygraph.models.RelationTypes
import io.personalitygraph.models.nodes.PersonalResult
import org.neo4j.ogm.annotation.*

@RelationshipEntity(type = RelationTypes.EXPANDS)
class Expands {
    @Id
    @GeneratedValue
    var id: Long? = null

    @StartNode
    var current: PersonalResult? = null

    @EndNode
    var parent: PersonalResult? = null
}