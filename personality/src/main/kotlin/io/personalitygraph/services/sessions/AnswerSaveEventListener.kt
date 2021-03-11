package io.personalitygraph.services.sessions

import io.personalitygraph.dao.RelationDao
import io.personalitygraph.models.nodes.Answer
import io.personalitygraph.models.relations.Affects
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.neo4j.ogm.session.event.Event
import org.neo4j.ogm.session.event.EventListener

@KoinApiExtension
class AnswerSaveEventListener : EventListener, KoinComponent {

    private val relationDao:RelationDao by inject()

    override fun onPostSave(event: Event?) {
        val item = event?.getObject()
        if (item is Answer) {
            val characteristic = item.characteristic!!
            val affectingValue = item.affectingValue!!
            val existing = relationDao.findRelationshipBetween(Affects::class, item, characteristic)
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