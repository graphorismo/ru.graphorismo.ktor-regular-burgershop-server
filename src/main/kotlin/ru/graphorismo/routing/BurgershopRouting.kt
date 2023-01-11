package ru.graphorismo.routing

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import ru.graphorismo.data.coupons.Coupon
import ru.graphorismo.data.coupons.CouponRepository
import ru.graphorismo.data.products.Product
import ru.graphorismo.data.products.ProductRepository

fun Routing.getProductsIds(){
    var productsRepository = ProductRepository.getInstance()

    get("/products/ids") {
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

fun Routing.getCouponsIds(){
    var couponsRepository = CouponRepository.getInstance()

    get("/coupons/ids") {
        call.respond(couponsRepository.getCouponsIds())
    }
}

fun Routing.getCouponUnderId(){
    var couponRepository = CouponRepository.getInstance()

    get("/coupon") {
        var coupons : List<Coupon> = listOf()
        if(call.request.queryParameters["id"] != null)
        {
            var id = call.request.queryParameters["id"]
            coupons = couponRepository.getCouponUnderId(id!!.toInt())

        }
        call.respond(coupons)

    }

}