package io.personalitygraph

import io.personalitygraph.dao.*
import io.personalitygraph.services.initializators.BuilderBasedInitService
import io.personalitygraph.services.InitService
import io.personalitygraph.services.sessions.AnswerSaveEventListener
import io.personalitygraph.services.sessions.Neo4jSessionFactory
import io.personalitygraph.services.sessions.StandaloneNeo4jSessionFactory
import org.koin.core.qualifier.named
import org.koin.dsl.module
import org.neo4j.ogm.session.event.EventListener

val personalityGraphModule = module(createdAtStart = true) {
    //listeners
    single(named("answerSaveEventListener")) { AnswerSaveEventListener() as EventListener }

    single { StandaloneNeo4jSessionFactory(get(named("answerSaveEventListener"))) as Neo4jSessionFactory }

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
    single { BuilderBasedInitService(get()) as InitService }
}