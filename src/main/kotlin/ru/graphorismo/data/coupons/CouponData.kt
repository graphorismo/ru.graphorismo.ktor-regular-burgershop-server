package ru.graphorismo.data.coupons

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Table

object CouponData : Table(name = "coupon_data") {
    val id: Column<Int> = integer("id").autoIncrement()
    val couponName: Column<String> = text("coupon_name").uniqueIndex()
    val productName: Column<String> = text("product_name")
    val discountPercents: Column<Int> = integer("discount_percents")

    override val primaryKey = PrimaryKey(id)

    fun toCoupon(row: ResultRow): Coupon {
        return Coupon(
            couponName = row[CouponData.couponName],
            productName = row[CouponData.productName],
            discountPercents = row[CouponData.discountPercents]
        )
    }

}