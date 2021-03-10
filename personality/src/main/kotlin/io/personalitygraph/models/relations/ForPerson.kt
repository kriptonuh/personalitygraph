package io.personalitygraph.models.relations

import io.personalitygraph.models.RelationTypes
import io.personalitygraph.models.nodes.*
import org.neo4j.ogm.annotation.*

@RelationshipEntity(type = RelationTypes.FOR_PERSON)
class ForPerson {
    @Id
    @GeneratedValue
    var id: Long? = null

    @StartNode
    var personalResult: PersonalResult? = null

    @EndNode
    var person: Person? = null
}