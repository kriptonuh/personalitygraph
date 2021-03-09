package io.personalitygraph.models.relations

import io.personalitygraph.models.nodes.Answer
import io.personalitygraph.models.nodes.Characteristic
import org.neo4j.ogm.annotation.*

@RelationshipEntity(type = "AFFECTS")
class Affects(
    @StartNode var answer: Answer,
    @EndNode var characteristic: Characteristic,
    @Property var modifier: Int
) {
    @Id
    @GeneratedValue
    var id: Long? = null
}