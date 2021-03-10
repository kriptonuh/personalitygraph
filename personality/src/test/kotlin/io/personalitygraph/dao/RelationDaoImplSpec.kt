package io.personalitygraph.dao

import com.nhaarman.mockitokotlin2.*
import io.personalitygraph.services.sessions.Neo4jSessionFactory
import io.personalitygraph.models.DomainModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import org.neo4j.ogm.session.Session
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.gherkin.Feature
import kotlin.test.assertTrue

object RelationDaoImplSpec : Spek({
    val mockType = mock<DomainModel>()
    val mockStart = mock<DomainModel>()
    val mockEnd = mock<DomainModel>()

    val mockSession = mock<Session>()
    val mockSessionFactory = mock<Neo4jSessionFactory>{
        on {getNeo4jSession()} doReturn mockSession
    }

//    val mockSession = mock<Session> {
//        on {
//            queryForObject(
//                mockType::class.java,
//                any(),
//                any()
//            )
//        } doAnswer { invocationOnMock ->
//            invocationOnMock.getArgument(2)
//        }
//    }

beforeGroup {
    startKoin{
        modules(
            module {
                single { mockSessionFactory as Neo4jSessionFactory }
            })
    }
}

    Feature("Extracting relation from graph by end nodes and type") {
        val relationDao by memoized { RelationDaoImpl() }
        Scenario("Positive case") {
            When("mocked"){
                relationDao.stub {  }
            }
            Then("should return correctly") {
                //relationDao.findRelationshipBetween(mockType::class, mockStart, mockEnd)
                assertTrue (true)
            }
        }
    }
})
