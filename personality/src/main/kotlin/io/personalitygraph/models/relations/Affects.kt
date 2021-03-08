package io.personalitygraph.models.relations

import io.personalitygraph.models.nodes.Answer
import io.personalitygraph.models.nodes.Characteristic
import org.neo4j.ogm.annotation.*

@RelationshipEntity(type = "AFFECTS")
class Affects {
    @Id
    @GeneratedValue
    val id: Long = 0

    @StartNode
    lateinit var answer: Answer

    @EndNode
    lateinit var characteristic: Characteristic

    @Property
    var modifier: Int = 0
}