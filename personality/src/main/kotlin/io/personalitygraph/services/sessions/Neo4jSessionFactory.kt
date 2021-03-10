package io.personalitygraph.services.sessions

import org.neo4j.ogm.config.ClasspathConfigurationSource
import org.neo4j.ogm.config.Configuration
import org.neo4j.ogm.session.Session
import org.neo4j.ogm.session.SessionFactory
import org.neo4j.ogm.session.event.EventListener

interface Neo4jSessionFactory {
    fun getNeo4jSession(): Session
}

class StandaloneNeo4jSessionFactory(private vararg val listeners: EventListener) : Neo4jSessionFactory {

    private val source = ClasspathConfigurationSource("ogm.properties")
    private val configuration = Configuration.Builder(source).build()
    private val sessionFactory = SessionFactory(configuration, "io.personalitygraph.models")

    override fun getNeo4jSession(): Session {
        val session = sessionFactory.openSession()
        listeners.forEach { session.register(it) }
        return session

    }
}