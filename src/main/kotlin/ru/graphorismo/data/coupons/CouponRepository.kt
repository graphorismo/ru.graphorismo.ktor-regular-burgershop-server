package ru.graphorismo.data.coupons

class CouponRepository(private val database: CouponDatabase) {
    companion object{
        private var instance : CouponRepository? = null

        fun getInstance() : CouponRepository{
            if (instance == null) instance = CouponRepository(CouponDatabase("coupon.db"))
            return instance!!
        }
    }

    fun getCouponsIds(): List<Int> {
        return database.getIds()
    }

    fun getCouponUnderId(id: Int) : List<Coupon> {
        return database.getCouponUnderId(id)
    }
}