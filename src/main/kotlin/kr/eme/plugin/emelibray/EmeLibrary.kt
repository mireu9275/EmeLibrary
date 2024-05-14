package kr.eme.plugin.emelibray

import org.bukkit.plugin.java.JavaPlugin

class EmeLibrary : JavaPlugin() {
    override fun onEnable() {
        logger.info("Eme Library is enabled")
    }
    override fun onDisable() {
        logger.info("Eme Library is disabled")
    }
}