package kr.eme.plugin.emeLibrary.managers

import kr.eme.plugin.emeLibrary.objects.User
import java.io.File
import java.util.UUID

object UserManager {
    lateinit var fileManager: FileManager<User>
    private val userMap = HashMap<UUID, User>()

    fun init(fileManager: FileManager<User>){
        this.fileManager = fileManager
    }
    fun addUser(uuid: UUID, amount: Long = 0) {
        val user = User(uuid, amount)
        userMap[uuid] = user
        fileManager.save("$uuid.yml", user)
    }
    fun removeUser(uuid: UUID) {
        userMap.remove(uuid)
        val file = File(fileManager.directory, "$uuid.yml")
        if (file.exists()) file.delete()
    }
    fun getUser(uuid: UUID): User? {
        return userMap[uuid] ?: loadUser(uuid)
    }
    fun saveUser(user: User) {
        userMap[user.uuid] = user
        fileManager.save("${user.uuid}.yml", user)
    }
    fun loadUser(uuid: UUID): User? {
        val user = fileManager.load("$uuid.yml")
        if (user != null) {
            userMap[uuid] = user
        } else {
            addUser(uuid)
        }
        return user
    }
    fun saveAllUsers() {
        for (user in userMap.values) {
            fileManager.save("${user.uuid}.yml", user)
        }
    }
}