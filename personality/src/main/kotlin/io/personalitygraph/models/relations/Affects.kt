package io.personalitygraph.models.relations

import io.personalitygraph.models.nodes.Answer
import io.personalitygraph.models.nodes.Characteristic
import org.neo4j.ogm.annotation.*

@RelationshipEntity(type = "AFFECTS")
class Affects {
    @Id
    @GeneratedValue
    var id: Long? = null

    @StartNode
    var answer: Answer? = null

    @EndNode
    var characteristic: Characteristic? = null

    @Property
    var modifier: Int = 0
}