package io.personalitygraph

import org.neo4j.ogm.config.ClasspathConfigurationSource
import org.neo4j.ogm.config.Configuration
import org.neo4j.ogm.session.Session
import org.neo4j.ogm.session.SessionFactory

interface Neo4jSessionFactory {
    fun getNeo4jSession(): Session
}

class StandaloneNeo4jSessionFactory : Neo4jSessionFactory {
    private val configurationSource: ClasspathConfigurationSource = ClasspathConfigurationSource("ogm.properties")
    private val configuration: Configuration = Configuration.Builder(configurationSource).build()
    private val sessionFactory: SessionFactory = SessionFactory(configuration, "io.personalitygraph.models.nodes", "io.personalitygraph.models.relations")

    override fun getNeo4jSession(): Session {
        return sessionFactory.openSession()
    }
}