package io.personalitygraph

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.response.*
import io.ktor.routing.*
import io.personalitygraph.dao.PersonDao
import io.personalitygraph.dao.PersonalResultDao
import io.personalitygraph.models.nodes.Person
import io.personalitygraph.services.initializators.InitService
import org.koin.ktor.ext.Koin
import org.koin.ktor.ext.getProperty
import org.koin.ktor.ext.inject
import kotlin.system.measureTimeMillis

fun main(args: Array<String>): Unit {
    io.ktor.server.netty.EngineMain.main(args)
}


/**
 * Please note that you can use any other name instead of *module*.
 * Also note that you can have more then one modules in your application.
 * */
fun Application.module() {
    install(CallLogging)
    install(ContentNegotiation)

    install(Koin) {
        modules(personalityGraphModule)
        fileProperties()
    }
    val personDao: PersonDao by inject()
    val personalResultDao: PersonalResultDao by inject()
    val initService: InitService by inject()

    routing {
        get("/") {
            val text = this@routing.getProperty("props.test", "not found")
            call.respondText(text)
        }
    }
    routing {
        get("/json/gson") {
            call.respond(mapOf("hello" to "world"))
        }
    }
    routing {
        get("/persons") {
            call.respond(personDao.findAll().joinToString())
        }
    }
    routing {
        get("/create") {
            val person = Person.Builder()
                .name("444")
                .build()
            personDao.createOrUpdate(person)
            call.respond("ok")
        }
    }
    routing {
        get("/init") {
            val time = measureTimeMillis { initService.init() }
            call.respond("initialized for ${time}ms")
        }
    }
}

