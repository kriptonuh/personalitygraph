package io.personalitygraph.dao

import io.personalitygraph.Neo4jSessionFactory
import io.personalitygraph.models.relations.Affects

interface AffectsDao : Dao<Affects>

class AffectsDaoImpl(neo4jSessionFactory: Neo4jSessionFactory) :
    GenericDao<Affects>(neo4jSessionFactory), AffectsDao {
    override fun getEntityType(): Class<Affects> {
        return Affects::class.java
    }
}