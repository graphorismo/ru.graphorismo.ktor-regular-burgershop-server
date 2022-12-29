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

    fun getProductsTitles(): List<String> {
        return database.getTitles()
    }

    fun getProductsUnderTitle(title: String) : List<Product>{
        return database.getProductsUnderTitle(title)
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