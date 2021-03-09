package io.personalitygraph.models

import org.neo4j.ogm.annotation.*


abstract class DomainModel {

    @Id
    @GeneratedValue
    var id: Long? = null


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as DomainModel

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }

}