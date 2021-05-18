package com.johnowl

import io.micronaut.context.annotation.Requires
import io.micronaut.http.MediaType.APPLICATION_JSON
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Produces

@Controller("/values")
@Requires(env = ["test"])
class MockController {

    @Get("/1")
    @Produces(APPLICATION_JSON)
    fun getValue1() = """
            {
                "value1": "11111",
                "value2": "22222"
            }
            """.trimMargin()

    @Get("/2")
    @Produces(APPLICATION_JSON)
    fun getValue2() = """
            {
                "value1": "11111",
                "value2": ""
            }
            """.trimMargin()
}