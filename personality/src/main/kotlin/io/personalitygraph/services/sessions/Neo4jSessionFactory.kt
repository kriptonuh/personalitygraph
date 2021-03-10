package io.personalitygraph

import org.koin.java.KoinJavaComponent
import org.neo4j.ogm.config.ClasspathConfigurationSource
import org.neo4j.ogm.config.Configuration
import org.neo4j.ogm.session.Session
import org.neo4j.ogm.session.SessionFactory
import org.neo4j.ogm.session.event.EventListener

interface Neo4jSessionFactory {
    fun getNeo4jSession(): Session
}

class StandaloneNeo4jSessionFactory(private vararg val listeners: EventListener) : Neo4jSessionFactory {
    private val configurationSource: ClasspathConfigurationSource =
        ClasspathConfigurationSource("ogm.properties")
    private val configuration: Configuration =
        Configuration.Builder(configurationSource).connectionPoolSize(8).build()
    private val sessionFactory: SessionFactory =
        SessionFactory(configuration, "io.personalitygraph.models.nodes", "io.personalitygraph.models.relations")

    override fun getNeo4jSession(): Session {
        val session = sessionFactory.openSession()
        listeners.forEach { session.register(it) }
        return session

    }
}