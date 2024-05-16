package kr.eme.plugin.emelibray

import kr.eme.plugin.emelibray.commands.MoneyCommands
import kr.eme.plugin.emelibray.objects.EmePlugin

class EmeLibrary : EmePlugin() {
    override fun onEnable() {
        main = this
        registerCommands()
        logger.info("Eme Library is enabled")
    }
    override fun onDisable() {
        logger.info("Eme Library is disabled")
    }
    private fun registerCommands() {
        registerCommands(
            "money" to MoneyCommands()
        )
    }
}
