package ru.graphorismo.data.products

import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.deleteAll
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class ProductRepository(private val database: ProductDatabase) {
    companion object{
        private var instance : ProductRepository? = null

        fun getInstance() : ProductRepository{
            if (instance == null) instance = ProductRepository(ProductDatabase("product.db"))
            return instance!!
        }
    }

    fun getProductsIds(): List<Int> {
        return database.getIds()
    }

    fun getProductUnderId(id: Int) : List<Product> {
        return database.getProductUnderId(id)
    }

    fun getAllProducts() : List<Product>{
        return database.getProducts()
    }

    fun addProduct(product: Product){
        database.addProduct(product)
    }

    fun deleteAllProducts(){
        database.deleteAll()
    }
}