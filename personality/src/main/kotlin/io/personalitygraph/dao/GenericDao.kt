package io.personalitygraph.dao

import io.personalitygraph.Neo4jSessionFactory
import org.neo4j.ogm.session.Session
import org.slf4j.LoggerFactory

abstract class GenericDao<T>(neo4jSessionFactory: Neo4jSessionFactory) : Dao<T> {
    private val log = LoggerFactory.getLogger(this::class.java.simpleName)
    private val defaultDepthList = 2
    private val defaultDepthEntity = 2
    protected val session: Session = neo4jSessionFactory.getNeo4jSession()


    override fun findAll(): Iterable<T> {
        log.debug("trying to find all items of type [${getEntityType().canonicalName}]")
        return session.loadAll(getEntityType(), defaultDepthList)
    }

    override fun find(id: Long): T {
        log.debug("trying to find item of type [${getEntityType().canonicalName}] for ID [$id]")
        return session.load(getEntityType(), id, defaultDepthEntity)
    }

    override fun delete(id: Long) {
        log.debug("trying to delete item of type [${getEntityType().canonicalName}] for ID [$id]")
        session.delete(session.load(getEntityType(), id))
    }

    override fun createOrUpdate(vararg items: T) {
        log.debug(
            "trying to create/update items of type [${getEntityType().canonicalName}] " +
                    "in batch mode. Count = ${items.size}"
        )
        items.forEach { createOrUpdate(it) }
    }

    override fun createOrUpdate(item: T) {
        log.debug("trying to create/update item of type [${getEntityType().canonicalName}]")
        session.save(item, defaultDepthEntity)
    }

    abstract fun getEntityType(): Class<T>

}