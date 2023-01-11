package ru.graphorismo.plugins

import io.ktor.server.routing.*
import io.ktor.server.http.content.*
import io.ktor.server.application.*
import ru.graphorismo.routing.getCouponUnderId
import ru.graphorismo.routing.getCouponsIds
import ru.graphorismo.routing.getProductUnderId
import ru.graphorismo.routing.getProductsIds

fun Application.configureRouting() {
    

    routing {
        getProductsIds()
        getProductUnderId()
        getCouponsIds()
        getCouponUnderId()
        // Static plugin. Try to access `/static/index.html`
        static("/static") {
            resources("static")
        }
    }
}
