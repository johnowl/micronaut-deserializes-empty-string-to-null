package com.johnowl

import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.client.annotation.Client

@Client("/")
interface ApiClient {

    @Get("/values/{id}")
    suspend fun getValue(@PathVariable id: String): Response

}
