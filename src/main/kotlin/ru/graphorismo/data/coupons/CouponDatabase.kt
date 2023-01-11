package ru.graphorismo.data.coupons

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

class CouponDatabase(name: String) {

    var dataBase : Database = Database.connect("jdbc:sqlite:data/${name}", "org.sqlite.JDBC")

    init {
        transaction (dataBase) {
            SchemaUtils.create(CouponData)
        }
    }

    fun getIds(): List<Int> {
        var coupons = transaction(dataBase) {
            var query = CouponData.selectAll()
            query.map { it[CouponData.id] }
        }
        return coupons
    }

    fun getCouponUnderId(id: Int) : List<Coupon> {
        var coupons = transaction(dataBase) {
            var query = CouponData.select {CouponData.id eq id}
            query.limit(1)
            query.map { CouponData.toCoupon(it) }
        }
        return coupons
    }

}