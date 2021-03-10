package io.personalitygraph.dao

import io.personalitygraph.models.nodes.Question

interface QuestionDao : NodeDao<Question>

class QuestionDaoImpl : GenericDao<Question>(), QuestionDao {
    override fun getEntityType(): Class<Question> {
        return Question::class.java
    }
}