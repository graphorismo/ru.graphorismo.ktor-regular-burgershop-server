package ru.graphorismo.data.products

import org.junit.Assert
import org.junit.Test

class ProductDatabaseTest {

    @Test
    fun ifGetTitlesFromEmptyDBThenReturnNothing(){
        var database = ProductDatabase("test/test_empty.db")
        val titles = database.getTitles()
        Assert.assertTrue(titles == listOf<String>())
    }

    @Test
    fun ifGetTitlesThenReturnTitles(){
        var database = ProductDatabase("test/test_titles.db")
        var product = Product("testTitle","testName",0,"No")
        database.addProduct(product)
        var titles = database.getTitles()
        Assert.assertTrue(titles.size == 1)
        Assert.assertTrue(titles[0] == "testTitle")
        database.deleteAll()
    }

    @Test
    fun ifAddProductThenItWillBeAdded(){
        var database = ProductDatabase("test/test_add.db")
        var product = Product("testTitle","testName",0,"No")
        database.addProduct(product)
        var products = database.getProducts()
        Assert.assertTrue(products.size == 1)
        Assert.assertTrue(products[0] == product)
        database.deleteAll()
    }

    @Test
    fun ifGetProductsUnderTitleThenReturnProductsUnderTitle(){
        var database = ProductDatabase("test/test_under_title.db")
        var productsIn = listOf(
            Product("testTitle1","testName1",0,"No"),
            Product("testTitle1","testName2",1,"No"),
            Product("testTitle2","testName3",2,"No"),
            Product("testTitle3","testName4",3,"No")
        )
        for (product in productsIn){
            database.addProduct(product)
        }
        var productsOut = database.getProductsUnderTitle("testTitle1")
        Assert.assertTrue(productsOut.size == 2)
        database.deleteAll()
    }
}