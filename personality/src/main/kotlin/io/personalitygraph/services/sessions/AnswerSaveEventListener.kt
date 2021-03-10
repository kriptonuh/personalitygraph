package io.personalitygraph.services.sessions

import io.personalitygraph.dao.RelationDao
import io.personalitygraph.models.nodes.Answer
import io.personalitygraph.models.relations.Affects
import org.koin.java.KoinJavaComponent.inject
import org.neo4j.ogm.session.event.Event
import org.neo4j.ogm.session.event.EventListener

class AnswerSaveEventListener : EventListener {

    private val relationDao by inject(RelationDao::class.java)

    override fun onPostSave(event: Event?) {
        val item = event?.getObject()
        if (item is Answer) {
            val characteristic = item.characteristic!!
            val affectingValue = item.affectingValue!!
            val existing = relationDao.findRelationshipBetween(Affects::class, characteristic, item)
            if (existing != null && existing.modifier == null) {
                existing.modifier = affectingValue
                relationDao.createOrUpdate(existing)
            }
        }
    }

    override fun onPreSave(event: Event?) {
    }

    override fun onPreDelete(event: Event?) {
    }

    override fun onPostDelete(event: Event?) {
    }
}