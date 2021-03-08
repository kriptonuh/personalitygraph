package io.personalitygraph.dao

import io.personalitygraph.Neo4jSessionFactory
import io.personalitygraph.models.nodes.Test

interface TestDao : Dao<Test>

class TestDaoImpl(neo4jSessionFactory: Neo4jSessionFactory) : GenericDao<Test>(neo4jSessionFactory), TestDao {
    override fun getEntityType(): Class<Test> {
        return Test::class.java
    }
}