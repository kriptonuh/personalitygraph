package io.personalitygraph.dao

import io.personalitygraph.models.nodes.Question
import org.koin.core.component.KoinApiExtension

interface QuestionDao : NodeDao<Question>

@KoinApiExtension
class QuestionDaoImpl : GenericDao<Question>(), QuestionDao {
    override fun getEntityType(): Class<Question> {
        return Question::class.java
    }
}