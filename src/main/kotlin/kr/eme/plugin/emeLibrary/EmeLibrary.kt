package kr.eme.plugin.emeLibrary

import kr.eme.plugin.emeLibrary.commands.MoneyCommands
import kr.eme.plugin.emeLibrary.listerners.MoneyListener
import kr.eme.plugin.emeLibrary.managers.FileManager
import kr.eme.plugin.emeLibrary.objects.EmePlugin

class EmeLibrary : EmePlugin() {
    override fun onEnable() {
        main = this
        FileManager.initialize()
        registerEvents()
        registerCommands()
        logger.info("Eme Library is enabled")
    }
    override fun onDisable() {
        logger.info("Eme Library is disabled")
    }
    private fun registerCommands() {
        registerCommands(
            "money" to MoneyCommands
        )
    }
    private fun registerEvents() {
        registerEvents(
            MoneyListener
        )
    }
}
