package io.personalitygraph

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.response.*
import io.ktor.routing.*
import io.personalitygraph.dao.PersonDao
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
}

