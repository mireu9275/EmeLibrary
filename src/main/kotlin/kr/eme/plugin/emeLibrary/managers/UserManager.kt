package kr.eme.plugin.emeLibrary.managers

import kr.eme.plugin.emeLibrary.objects.User
import java.util.UUID

object UserManager {
    private val userMap = HashMap<UUID, User>()
    fun getUser(uuid: UUID) = userMap[uuid]
    fun addUser(uuid: UUID, amount: Long) {
        userMap[uuid] = User(amount)
    }
    fun removeUser(uuid: UUID) {
        userMap.remove(uuid)
    }
    fun setUserMoney(uuid: UUID, amount: Long) {
        val user = getUser(uuid) ?: return
        user.setMoney(amount)
    }
    fun withdrawUserMoney(uuid: UUID, amount: Long) {
        val user = getUser(uuid) ?: return
        user.withdrawMoney(amount)
    }
    fun depositUserMoney(uuid: UUID, amount: Long) {
        val user = getUser(uuid) ?: return
        user.depositMoney(amount)
    }
}