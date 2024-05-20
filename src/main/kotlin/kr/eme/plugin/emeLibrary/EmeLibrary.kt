package kr.eme.plugin.emeLibrary

import kr.eme.plugin.emeLibrary.commands.MoneyCommands
import kr.eme.plugin.emeLibrary.listeners.GUIListener
import kr.eme.plugin.emeLibrary.listeners.MoneyListener
import kr.eme.plugin.emeLibrary.managers.FileManager
import kr.eme.plugin.emeLibrary.managers.UserManager
import kr.eme.plugin.emeLibrary.objects.EmePlugin
import kr.eme.plugin.emeLibrary.objects.User
import java.io.File

class EmeLibrary : EmePlugin() {
    override fun onEnable() {
        main = this
        val fileManager = FileManager(User::class.java, File(dataFolder, "Users"))
        UserManager.init(fileManager)
        registerEvents()
        registerCommands()
        logger.info("Eme Library is enabled")
    }
    override fun onDisable() {
        UserManager.saveAllUsers()
        logger.info("Eme Library is disabled")
    }
    private fun registerCommands() {
        registerCommands(
            MoneyCommands
        )
    }
    private fun registerEvents() {
        registerEvents(
            MoneyListener,
            GUIListener
        )
    }
}
