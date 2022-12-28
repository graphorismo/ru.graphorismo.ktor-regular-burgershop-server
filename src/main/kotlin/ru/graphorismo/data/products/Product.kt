package ru.graphorismo.data.products

import org.jetbrains.exposed.sql.Column
import ru.graphorismo.data.products.ProductData.autoIncrement
import ru.graphorismo.data.products.ProductData.uniqueIndex

data class Product(val title: String, val name: String, val price: Int, val pictureUrl: String) {

}
