package com.johnowl

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable

@Controller
class IndexController(
    private val apiClient: ApiClient
) {

    @Get("/index/{id}")
    suspend fun index(@PathVariable id: String): Response {
        return apiClient.getValue(id)
    }
}