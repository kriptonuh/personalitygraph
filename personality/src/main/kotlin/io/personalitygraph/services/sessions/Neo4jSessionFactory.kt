package io.personalitygraph.services.sessions

import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.qualifier.named
import org.neo4j.ogm.config.ClasspathConfigurationSource
import org.neo4j.ogm.config.Configuration
import org.neo4j.ogm.session.Session
import org.neo4j.ogm.session.SessionFactory
import org.neo4j.ogm.session.event.EventListener

interface Neo4jSessionFactory {
    fun getNeo4jSession(): Session
}

@KoinApiExtension
class StandaloneNeo4jSessionFactory : Neo4jSessionFactory, KoinComponent {

    private val source = ClasspathConfigurationSource("ogm.properties")
    private val configuration = Configuration.Builder(source).build()
    private val sessionFactory = SessionFactory(configuration, "io.personalitygraph.models")
    private val listeners: Set<EventListener> by inject(named("interceptors"))

    override fun getNeo4jSession(): Session {
        val session = sessionFactory.openSession()
        listeners.forEach { session.register(it) }
        return session

    }
}