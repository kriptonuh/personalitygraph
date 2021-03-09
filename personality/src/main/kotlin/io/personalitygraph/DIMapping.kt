package io.personalitygraph

import io.personalitygraph.dao.*
import io.personalitygraph.services.initializators.BuilderBasedInitService
import io.personalitygraph.services.InitService
import org.koin.dsl.module

val personalityGraphModule = module(createdAtStart = true) {
    single { StandaloneNeo4jSessionFactory() as Neo4jSessionFactory }

    //DAO
    single { PersonDaoImpl(get()) as PersonDao }
    single { TestDaoImpl(get()) as TestDao }
    single { PersonalResultDaoImpl(get()) as PersonalResultDao }
    single { QuestionTypeDaoImpl(get()) as QuestionTypeDao }
    single { QuestionDaoImpl(get()) as QuestionDao }
    single { CharacteristicDaoImpl(get()) as CharacteristicDao }
    single { AnswerDaoImpl(get(), get()) as AnswerDao }
    single { ResultDaoImpl(get()) as ResultDao }
    single { AffectsDaoImpl(get()) as AffectsDao }

    //Services
    single { BuilderBasedInitService(get(), get(), get(), get(), get(), get(), get(), get(), get()) as InitService }
}