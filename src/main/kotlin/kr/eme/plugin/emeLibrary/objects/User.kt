package kr.eme.plugin.emeLibrary.objects

class User(initMoney : Long = 0) {
    private var money: Long = initMoney

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