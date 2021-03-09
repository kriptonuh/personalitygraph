package io.personalitygraph

import io.personalitygraph.dao.*
import org.koin.dsl.module

val personalityGraphModule = module {
    single(createdAtStart = true) { StandaloneNeo4jSessionFactory() as Neo4jSessionFactory}
    single(createdAtStart = true) { PersonDaoImpl(get()) as PersonDao}
    single(createdAtStart = true) { TestDaoImpl(get()) as TestDao}
    single(createdAtStart = true) { PersonalResultDaoImpl(get()) as PersonalResultDao}
}