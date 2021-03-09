package io.personalitygraph.dao

import io.personalitygraph.Neo4jSessionFactory
import io.personalitygraph.models.nodes.Question

interface QuestionDao : Dao<Question>

class QuestionDaoImpl(neo4jSessionFactory: Neo4jSessionFactory) :
    GenericDao<Question>(neo4jSessionFactory), QuestionDao {
    override fun getEntityType(): Class<Question> {
        return Question::class.java
    }
}