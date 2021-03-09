package io.personalitygraph

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.response.*
import io.ktor.routing.*
import io.personalitygraph.dao.PersonDao
import io.personalitygraph.dao.PersonalResultDao
import io.personalitygraph.models.nodes.Person
import io.personalitygraph.models.nodes.PersonalResult
import org.koin.ktor.ext.Koin
import org.koin.ktor.ext.inject
import org.koin.logger.slf4jLogger

fun main(args: Array<String>): Unit {
    io.ktor.server.netty.EngineMain.main(args)
}


/**
 * Please note that you can use any other name instead of *module*.
 * Also note that you can have more then one modules in your application.
 * */
@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    install(CallLogging)
    install(ContentNegotiation)

    install(Koin) {
        slf4jLogger()
        modules(personalityGraphModule)
    }
    val personDao: PersonDao by inject()
    val personalResultDao: PersonalResultDao by inject()

    routing {
        get("/") {
            call.respondText("message")
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
            val person = Person()
            person.name = "2222"
            person.addResult(PersonalResult())
            personDao.createOrUpdate(person)
            call.respond("ok")
        }
    }
}

