package io.personalitygraph.dao

import io.personalitygraph.Neo4jSessionFactory
import io.personalitygraph.models.nodes.Result

interface ResultDao : Dao<Result>

class ResultDaoImpl(neo4jSessionFactory: Neo4jSessionFactory) :
    GenericDao<Result>(neo4jSessionFactory), ResultDao {
    override fun getEntityType(): Class<Result> {
        return Result::class.java
    }
}