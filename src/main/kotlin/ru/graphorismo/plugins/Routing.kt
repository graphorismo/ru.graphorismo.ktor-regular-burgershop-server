package ru.graphorismo.plugins

import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.http.content.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*
import ru.graphorismo.routing.getProductsUnderTitle
import ru.graphorismo.routing.getTitles

fun Application.configureRouting() {
    

    routing {
        getTitles()
        getProductsUnderTitle()
        // Static plugin. Try to access `/static/index.html`
        static("/static") {
            resources("static")
        }
    }
}
