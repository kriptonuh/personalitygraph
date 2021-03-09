package io.personalitygraph.dao

import io.personalitygraph.Neo4jSessionFactory
import io.personalitygraph.models.nodes.Answer
import io.personalitygraph.models.relations.Affects

interface AnswerDao : Dao<Answer>

class AnswerDaoImpl(
    neo4jSessionFactory: Neo4jSessionFactory,
    val affectsDao: AffectsDao
) :
    GenericDao<Answer>(neo4jSessionFactory), AnswerDao {
    override fun getEntityType(): Class<Answer> {
        return Answer::class.java
    }

    override fun createOrUpdate(vararg items: Answer) {
        items.forEach { createOrUpdate(it) }
    }

    override fun createOrUpdate(item: Answer): Answer {
        affectsDao.createOrUpdate(
            Affects.Builder()
                .answer(item)
                .characteristic(item.characteristic!!)
                .modifier(item.affectingValue!!)
                .build()
        )
        return super.createOrUpdate(item)
    }
}