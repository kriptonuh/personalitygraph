package io.personalitygraph.dao

import io.personalitygraph.Neo4jSessionFactory
import io.personalitygraph.models.nodes.Characteristic

interface CharacteristicDao : Dao<Characteristic>

class CharacteristicDaoImpl(neo4jSessionFactory: Neo4jSessionFactory) :
    GenericDao<Characteristic>(neo4jSessionFactory), CharacteristicDao {
    override fun getEntityType(): Class<Characteristic> {
        return Characteristic::class.java
    }
}