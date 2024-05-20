package kr.eme.plugin.emeLibrary.managers

import java.util.*

object UserMoneyManager {
    fun getUserMoney(uuid: UUID): Long {
        val user = UserManager.getUser(uuid) ?: return 0
        return user.money
    }
    fun setUserMoney(uuid: UUID, amount: Long) {
        val user = UserManager.getUser(uuid) ?: return
        user.money = amount
        UserManager.saveUser(user)
    }
    fun withdrawUserMoney(uuid: UUID, amount: Long) {
        val user = UserManager.getUser(uuid) ?: return
        if (user.money >= amount) {
            user.money -= amount
            UserManager.saveUser(user)
        } else {
            throw IllegalArgumentException("Insufficient funds")
        }
    }
    fun depositUserMoney(uuid: UUID, amount: Long) {
        val user = UserManager.getUser(uuid) ?: return
        user.money += amount
        UserManager.saveUser(user)
    }
}