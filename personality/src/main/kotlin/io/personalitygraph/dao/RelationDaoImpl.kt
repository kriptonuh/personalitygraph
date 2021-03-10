package io.personalitygraph.dao

import io.personalitygraph.services.sessions.Neo4jSessionFactory
import io.personalitygraph.models.DomainModel
import org.koin.core.qualifier.named
import org.koin.java.KoinJavaComponent.inject
import org.neo4j.ogm.session.Session
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import kotlin.reflect.KClass

class RelationDaoImpl : RelationDao {
    private val log: Logger = LoggerFactory.getLogger(this::class.qualifiedName)

    private val relationTypesMap by inject(Map::class.java, named("relationTypesMap"))
    private val neo4jSessionFactory by inject(Neo4jSessionFactory::class.java)
    private val session: Session = neo4jSessionFactory.getNeo4jSession()

    override fun <T : DomainModel, S : DomainModel, E : DomainModel>
            findRelationshipBetween(resultType: KClass<T>, start: S, end: E): T? {

        val relationName = relationTypesMap[resultType]
            ?: throw RuntimeException("Cannot find relation for class [${resultType.qualifiedName}]")

        val query = "match (start)-[relation:${relationName}]->(end) " +
                "where id(start)=${start.id} and id(end)=${end.id} " +
                "return relation, start, end"

        log.debug("Trying to find relations using query[$query]")
        return session.queryForObject(resultType.java, query, mapOf<String, String>())
    }

    override fun <T : DomainModel> createOrUpdate(item: T, depth: Int) {
        log.debug("trying to create/update item of type [${item::class.simpleName}]")
        session.save(item, depth)
    }
}