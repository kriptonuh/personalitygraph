package io.personalitygraph.dao

import io.personalitygraph.Neo4jSessionFactory
import io.personalitygraph.models.nodes.Person
import io.personalitygraph.models.nodes.PersonalResult

interface PersonalResultDao : Dao<PersonalResult>

class PersonalResultDaoImpl(neo4jSessionFactory: Neo4jSessionFactory) :
    GenericDao<PersonalResult>(neo4jSessionFactory), PersonalResultDao {
    override fun getEntityType(): Class<PersonalResult> {
        return PersonalResult::class.java
    }
}