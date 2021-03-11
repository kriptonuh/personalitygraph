package io.personalitygraph

import io.personalitygraph.dao.*
import io.personalitygraph.models.RelationTypes
import io.personalitygraph.services.initializators.BuilderBasedInitService
import io.personalitygraph.services.initializators.InitService
import io.personalitygraph.services.sessions.AnswerSaveEventListener
import io.personalitygraph.services.sessions.Neo4jSessionFactory
import io.personalitygraph.services.sessions.StandaloneNeo4jSessionFactory
import org.koin.core.component.KoinApiExtension
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module
import org.koin.experimental.property.inject
import org.neo4j.ogm.session.Session
import org.neo4j.ogm.session.event.EventListener

@OptIn(KoinApiExtension::class)
val personalityGraphModule = module(createdAtStart = true) {
    //listeners
    single(named("interceptors")) { setOf(AnswerSaveEventListener()) }

    //DAO
    single { PersonDaoImpl() as PersonDao }
    single { TestDaoImpl() as TestDao }
    single { PersonalResultDaoImpl() as PersonalResultDao }
    single { QuestionTypeDaoImpl() as QuestionTypeDao }
    single { QuestionDaoImpl() as QuestionDao }
    single { CharacteristicDaoImpl() as CharacteristicDao }
    single { AnswerDaoImpl() as AnswerDao }
    single { ResultDaoImpl() as ResultDao }
    single { RelationDaoImpl() as RelationDao }

    //Services
    single { BuilderBasedInitService() as InitService }
    single { StandaloneNeo4jSessionFactory() as Neo4jSessionFactory }
    factory(named("neo4jSession")) {
        val factory: Neo4jSessionFactory by inject()
        factory.getNeo4jSession() as Session
    }

    single(named("relationTypesMap")) { RelationTypes.RELATION_TYPES_MAP }
}