package io.personalitygraph.dao

import io.personalitygraph.models.nodes.Answer
import org.koin.core.component.KoinApiExtension

interface AnswerDao : NodeDao<Answer>

@KoinApiExtension
class AnswerDaoImpl : GenericDao<Answer>(), AnswerDao {
    override fun getEntityType(): Class<Answer> {
        return Answer::class.java
    }

    override fun createOrUpdate(vararg items: Answer, depth: Int) {
        items.forEach { createOrUpdate(it) }
    }
}