package io.personalitygraph.services.sessions

import io.personalitygraph.models.nodes.Answer
import org.koin.java.KoinJavaComponent.inject
import org.neo4j.ogm.session.event.Event
import org.neo4j.ogm.session.event.EventListener

class AnswerSaveEventListener : EventListener {

    //private val affectsDao by inject(AffectsDao::class.java)

    override fun onPostSave(event: Event?) {
        val item = event?.getObject()
        if (item is Answer) {
            val characteristic = item.characteristic!!
            val affectingValue = item.affectingValue!!
        }
    }

    override fun onPreSave(event: Event?) {
    }

    override fun onPreDelete(event: Event?) {
    }

    override fun onPostDelete(event: Event?) {
    }
}