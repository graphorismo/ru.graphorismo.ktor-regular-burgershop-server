package ru.graphorismo.data.products

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

class ProductDatabase(name: String) {

    var dataBase : Database = Database.connect("jdbc:sqlite:data/${name}", "org.sqlite.JDBC")

    init {
        transaction (dataBase) {
            SchemaUtils.create(ProductData)
        }
    }

    fun getIds(): List<Int> {
        var products = transaction(dataBase) {
            var query = ProductData.selectAll()
            query.map { it[ProductData.id] }
        }
        return products
    }

    fun getProductUnderId(id: Int) : List<Product> {
        var products = transaction(dataBase) {
            var query = ProductData.select {ProductData.id eq id}
            query.limit(1)
            query.map { ProductData.toProduct(it) }
        }
        return products
    }

    fun getProducts() : List<Product>{
        var products = transaction(dataBase) {
            var query = ProductData.selectAll().groupBy(ProductData.title)
            query.map { ProductData.toProduct(it) }
        }
        return products
    }

    fun addProduct(product: Product){
        transaction(dataBase) {
            ProductData.insert {
                it[ProductData.title] = product.title
                it[ProductData.name] = product.name
                it[ProductData.price] = product.price
                it[ProductData.pictureUrl] = product.pictureUrl
            }
        }
    }

    fun deleteAll(){
        transaction { ProductData.deleteAll() }
    }


}