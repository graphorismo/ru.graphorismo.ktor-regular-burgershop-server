package ru.graphorismo.routing

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import ru.graphorismo.data.products.Product
import ru.graphorismo.data.products.ProductRepository

fun Routing.getTitles(){
    var productsRepository = ProductRepository.getInstance()

    get("/titles") {
        call.respond(productsRepository.getProductsTitles())
    }
}

fun Routing.getProductsUnderTitle(){
    var productsRepository = ProductRepository.getInstance()

    get("/products") {
        var products = listOf<Product>()
        if(call.request.queryParameters["title"] != null)
        {
            var title = call.request.queryParameters["title"]
            products = productsRepository.getProductsUnderTitle(title!!)
        }
        call.respond(products)
    }

}