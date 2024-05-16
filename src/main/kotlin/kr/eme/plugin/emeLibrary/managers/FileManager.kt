package kr.eme.plugin.emeLibrary.managers

import kr.eme.plugin.emeLibrary.main
import org.bukkit.entity.Player
import java.io.File

object FileManager {
    private val userFolder : File = File("${main.dataFolder}\\emeUser")

    fun initialize() {
        createUsersFolder()
    }
    private fun createUsersFolder() {
        if (!userFolder.exists()) {
            userFolder.mkdirs()
            main.logger.info("Created user folder ${userFolder.absolutePath}")
        }
    }
    fun createUserConfigFile(player: Player) : Boolean {
        val uuid = player.uniqueId.toString()
        val configFile = File(main.dataFolder, uuid)
        if (!configFile.exists()) {
            main.saveDefaultConfig()
            main.logger.info("Created user config file ${configFile.absolutePath}")
            return true
        }
        return false
    }
    fun loadUserConfigFile(player: Player) : Boolean {
        val uuid = player.uniqueId.toString()
        val configFile = File(main.dataFolder, uuid)
        if (!configFile.exists()) return false
        // loadUserMoney
        return true
    }
}