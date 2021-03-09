package io.personalitygraph.dao

import io.personalitygraph.Neo4jSessionFactory
import io.personalitygraph.models.nodes.Person

interface PersonDao : Dao<Person>

class PersonDaoImpl(neo4jSessionFactory: Neo4jSessionFactory) :
    GenericDao<Person>(neo4jSessionFactory), PersonDao {
    override fun getEntityType(): Class<Person> {
        return Person::class.java
    }
}