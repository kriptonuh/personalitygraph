package io.personalitygraph.dao

import io.personalitygraph.models.nodes.QuestionType
import org.koin.core.component.KoinApiExtension

interface QuestionTypeDao : NodeDao<QuestionType>

@KoinApiExtension
class QuestionTypeDaoImpl : GenericDao<QuestionType>(), QuestionTypeDao {
    override fun getEntityType(): Class<QuestionType> {
        return QuestionType::class.java
    }
}