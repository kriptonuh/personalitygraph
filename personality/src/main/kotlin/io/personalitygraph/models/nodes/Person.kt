package io.personalitygraph.models.nodes

import org.neo4j.ogm.annotation.GeneratedValue
import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.Relationship


@NodeEntity
class Person {
    @Id
    @GeneratedValue
    val id: Long = 0
    lateinit var name: String

    lateinit var personalResults: Set<PersonalResult>

    override fun toString(): String {
        return "Person(id=$id, name='$name')"
    }

    //@Relationship(type = "HAS", direction = "INCOMING")
    //lateinit var characteristics: Set<Characteristic>


}