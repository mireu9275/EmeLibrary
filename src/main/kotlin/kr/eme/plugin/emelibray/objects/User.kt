package kr.eme.plugin.emelibray.objects

class User {
    private var money: Long = 0

    fun getMoney(): Long = money
    fun setMoney(amount: Long) {
        this.money = amount
    }
    fun withdrawMoney(amount: Long) {
        this.money -= amount
    }
    fun depositMoney(amount: Long) {
        this.money += amount
    }
}