package ru.graphorismo.plugins

import io.ktor.server.routing.*
import io.ktor.server.http.content.*
import io.ktor.server.application.*
import ru.graphorismo.routing.getProductUnderId
import ru.graphorismo.routing.getTitles

fun Application.configureRouting() {
    

    routing {
        getTitles()
        getProductUnderId()
        // Static plugin. Try to access `/static/index.html`
        static("/static") {
            resources("static")
        }
    }
}
