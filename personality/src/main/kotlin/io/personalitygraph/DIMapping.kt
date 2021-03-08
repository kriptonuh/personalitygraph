package io.personalitygraph

import io.personalitygraph.dao.PersonDao
import io.personalitygraph.dao.PersonDaoImpl
import io.personalitygraph.dao.TestDaoImpl
import org.koin.dsl.module

val personalityGraphModule = module {
    single(createdAtStart = true) { StandaloneNeo4jSessionFactory() as Neo4jSessionFactory}
    single(createdAtStart = true) { PersonDaoImpl(get()) as PersonDao}
    single(createdAtStart = true) { TestDaoImpl(get()) }
}