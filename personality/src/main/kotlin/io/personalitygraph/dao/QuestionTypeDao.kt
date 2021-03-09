package io.personalitygraph.dao

import io.personalitygraph.Neo4jSessionFactory
import io.personalitygraph.models.nodes.QuestionType

interface QuestionTypeDao : Dao<QuestionType>

class QuestionTypeDaoImpl(neo4jSessionFactory: Neo4jSessionFactory) :
    GenericDao<QuestionType>(neo4jSessionFactory), QuestionTypeDao {
    override fun getEntityType(): Class<QuestionType> {
        return QuestionType::class.java
    }
}