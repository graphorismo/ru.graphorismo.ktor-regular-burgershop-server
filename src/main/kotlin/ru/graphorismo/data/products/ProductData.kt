package ru.graphorismo.data.products

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Table

object ProductData : Table(name = "product_data") {
    val id: Column<Int> = integer("id").autoIncrement()
    val title: Column<String> = text("title")
    val name: Column<String> = text("name").uniqueIndex()
    val price: Column<Int> = integer("price")
    val pictureUrl: Column<String> = text("picture_url")

    override val primaryKey = PrimaryKey(id)

    fun toProduct(row: ResultRow): Product {
        return Product(
            title = row[ProductData.title],
            name = row[ProductData.name],
            price = row[ProductData.price],
            pictureUrl = row[ProductData.pictureUrl]
        )
    }

}