package io.personalitygraph.dao

import io.personalitygraph.Neo4jSessionFactory
import org.koin.core.logger.Level
import org.koin.core.logger.Level.*
import org.koin.core.logger.Logger
import org.koin.logger.slf4jLogger
import org.neo4j.ogm.session.Session
import org.koin.ktor.ext.inject
import org.slf4j.LoggerFactory

abstract class GenericDao<T>(private val neo4jSessionFactory: Neo4jSessionFactory) : Dao<T> {
    private val DEPTH_LIST = 0
    private val DEPTH_ENTITY = 1
    private val log = LoggerFactory.getLogger(this::class.java.simpleName)
    protected val session: Session = neo4jSessionFactory.getNeo4jSession()


    override fun findAll(): Iterable<T> {
        //println("trying to find all items of type [${getEntityType().canonicalName}]")
        log.debug("trying to find all items of type [${getEntityType().canonicalName}]")
        return session.loadAll(getEntityType(), DEPTH_LIST)
    }

    override fun find(id: Long): T {
        log.debug("trying to find item of type [${getEntityType().canonicalName}] for ID [$id]")
        return session.load(getEntityType(), id, DEPTH_ENTITY)
    }

    override fun delete(id: Long) {
        log.debug("trying to delete item of type [${getEntityType().canonicalName}] for ID [$id]")
        session.delete(session.load(getEntityType(), id))
    }

    override fun createOrUpdate(item: T) {
        log.debug("trying to create/update item of type [${getEntityType().canonicalName}]")
        session.save(item, DEPTH_ENTITY)
    }

    abstract fun getEntityType(): Class<T>

}