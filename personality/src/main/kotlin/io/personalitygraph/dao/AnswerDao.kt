package io.personalitygraph.dao

import io.personalitygraph.models.nodes.Answer

interface AnswerDao : NodeDao<Answer>

class AnswerDaoImpl : GenericDao<Answer>(), AnswerDao {
    override fun getEntityType(): Class<Answer> {
        return Answer::class.java
    }

    override fun createOrUpdate(vararg items: Answer, depth: Int) {
        items.forEach { createOrUpdate(it) }
    }
}