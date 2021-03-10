package io.personalitygraph.dao

import io.personalitygraph.Neo4jSessionFactory
import io.personalitygraph.models.DomainModel
import io.personalitygraph.models.RelationTypes
import org.koin.java.KoinJavaComponent
import org.neo4j.ogm.session.Session
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import kotlin.reflect.KClass

class RelationDaoImpl : RelationDao {
    private val neo4jSessionFactory by KoinJavaComponent.inject(Neo4jSessionFactory::class.java)
    private val session: Session = neo4jSessionFactory.getNeo4jSession()

    private val log: Logger = LoggerFactory.getLogger(this::class.qualifiedName)

    override fun <T : DomainModel, S : DomainModel, E : DomainModel>
            findRelationshipBetween(resultType: KClass<T>, start: S, end: E): T {

        val relationName = RelationTypes.RELATION_TYPES_MAP[resultType]
            ?: throw RuntimeException("Cannot find relation for class [${resultType.qualifiedName}]")

        val query = "match (start)-[relation:${relationName}]->(end) " +
                "where id(start)=${start.id} and id(end)=${end.id} " +
                "return relation, start, end"

        log.debug("Trying to find relations using query[$query]")
        return session.queryForObject(resultType.java, query, mapOf<String, String>())
    }
}