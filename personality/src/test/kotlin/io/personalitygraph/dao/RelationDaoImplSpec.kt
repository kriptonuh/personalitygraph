package io.personalitygraph.dao

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import io.personalitygraph.MockInjector.mockInjections
import io.personalitygraph.models.DomainModel
import io.personalitygraph.services.sessions.Neo4jSessionFactory
import org.koin.core.component.KoinApiExtension
import org.koin.core.qualifier.named
import org.neo4j.ogm.session.Session
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.gherkin.Feature

@KoinApiExtension
object RelationDaoImplSpec : Spek({
    val mockType = mock<DomainModel>()
    val mockStart = mock<DomainModel>()
    val mockEnd = mock<DomainModel>()
    val mockSession = mock<Session>()

    val mockSessionFactory = mock<Neo4jSessionFactory> {
        on { getNeo4jSession() } doReturn mockSession
    }

    beforeGroup {
        mockInjections {
            single { mockSessionFactory as Neo4jSessionFactory }
            single(named("relationTypesMap")) { mapOf(mockType::class to "test") }
        }
    }

    Feature("Extracting relation from graph by end nodes and type") {
        val relationDao by memoized { RelationDaoImpl() }
        Scenario("Positive case") {
            Then("Sould execute query") {
                relationDao.findRelationshipBetween(mockType::class, mockStart, mockEnd)
                verify(mockSession).queryForObject(any(), any(), any())
            }
        }
    }
})
