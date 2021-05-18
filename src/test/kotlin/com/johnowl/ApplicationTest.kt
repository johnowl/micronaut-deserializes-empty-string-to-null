package com.johnowl
import io.micronaut.http.HttpRequest.GET
import io.micronaut.http.client.RxHttpClient
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest(environments = ["test"])
class ApplicationTest {

    @Inject
    lateinit var embeddedServer: EmbeddedServer

    @Inject
    lateinit var httpClient: RxHttpClient

    @Test
    fun `should return response with two values filled`() {
        val response = httpClient.toBlocking().retrieve(GET<Any>("${embeddedServer.url}/index/1"), Response::class.java)

        assertEquals("11111", response.value1)
        assertEquals("22222", response.value2)
    }

    @Test
    fun `should return response with one value empty`() {
        val response = httpClient.toBlocking().retrieve(GET<Any>("${embeddedServer.url}/index/2"), Response::class.java)

        assertEquals("11111", response.value1)
        assertEquals("", response.value2)
    }
}
