package io.personalitygraph.models

import org.neo4j.ogm.annotation.*


abstract class DomainModel {

    @Id
    @GeneratedValue
    var id: Long? = null

}