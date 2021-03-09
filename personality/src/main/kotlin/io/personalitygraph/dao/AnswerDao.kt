package io.personalitygraph.dao

import io.personalitygraph.Neo4jSessionFactory
import io.personalitygraph.models.nodes.Answer

interface AnswerDao : Dao<Answer>

class AnswerDaoImpl(neo4jSessionFactory: Neo4jSessionFactory) :
    GenericDao<Answer>(neo4jSessionFactory), AnswerDao {
    override fun getEntityType(): Class<Answer> {
        return Answer::class.java
    }
}