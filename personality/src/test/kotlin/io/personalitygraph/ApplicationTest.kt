package io.personalitygraph

import io.ktor.features.*
import org.slf4j.event.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.gson.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import kotlin.test.*
import io.ktor.server.testing.*

class ApplicationTest {
	@Test
	fun testRoot() {
	    withTestApplication({ module() }) {
	        handleRequest(HttpMethod.Get, "/").apply {
	            assertEquals(HttpStatusCode.OK, response.status())
	            assertEquals("Hello World!", response.content)
	        }
	    }
	}
}