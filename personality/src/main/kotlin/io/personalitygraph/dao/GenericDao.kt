package io.personalitygraph.dao

import io.personalitygraph.models.DomainModel
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.qualifier.named
import org.neo4j.ogm.session.Session
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@KoinApiExtension
abstract class GenericDao<T : DomainModel> : NodeDao<T>, KoinComponent {
    private val log: Logger = LoggerFactory.getLogger(this::class.qualifiedName)
    override var defaultDepth = 3
    protected val session: Session by inject(named("neo4jSession"))

    override fun findAll(depth: Int): Iterable<T> {
        log.debug("trying to find all items of type [${getEntityType().canonicalName}]")
        return session.loadAll(getEntityType(), depth)
    }

    override fun find(id: Long, depth: Int): T {
        log.debug("trying to find item of type [${getEntityType().canonicalName}] for ID [$id]")
        return session.load(getEntityType(), id, depth)
    }

    override fun delete(id: Long, depth: Int) {
        log.debug("trying to delete item of type [${getEntityType().canonicalName}] for ID [$id]")
        session.delete(session.load(getEntityType(), id))
    }

    override fun createOrUpdate(vararg items: T, depth: Int) {
        log.debug(
            "trying to create/update items of type [${getEntityType().canonicalName}] " +
                    "in batch mode. Count = ${items.size}"
        )
        items.forEach { createOrUpdate(it) }
    }

    override fun createOrUpdate(item: T, depth: Int): T {
        log.debug("trying to create/update item of type [${getEntityType().canonicalName}]")
        session.save(item, depth)
        val id = item.id
        if (id != null)
            return find(id)
        else
            throw RuntimeException("Could not save item $item")
    }

    abstract fun getEntityType(): Class<T>

}