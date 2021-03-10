package io.personalitygraph.dao

import io.personalitygraph.models.nodes.QuestionType

interface QuestionTypeDao : NodeDao<QuestionType>

class QuestionTypeDaoImpl : GenericDao<QuestionType>(), QuestionTypeDao {
    override fun getEntityType(): Class<QuestionType> {
        return QuestionType::class.java
    }
}