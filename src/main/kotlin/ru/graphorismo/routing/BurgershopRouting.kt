package ru.graphorismo.routing

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import ru.graphorismo.data.products.Product
import ru.graphorismo.data.products.ProductRepository

fun Routing.getTitles(){
    var productsRepository = ProductRepository.getInstance()

    get("/ids") {
        call.respond(productsRepository.getProductsIds())
    }
}

fun Routing.getProductUnderId(){
    var productsRepository = ProductRepository.getInstance()

    get("/product") {
        var products : List<Product> = listOf()
        if(call.request.queryParameters["id"] != null)
        {
            var id = call.request.queryParameters["id"]
            products = productsRepository.getProductUnderId(id!!.toInt())

        }
        call.respond(products)

    }

}