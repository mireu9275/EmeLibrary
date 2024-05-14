package kr.eme.plugin.emelibray

import kr.eme.plugin.emelibray.objects.EmePlugin

class EmeLibrary : EmePlugin() {
    override fun onEnable() {
        main = this
        logger.info("Eme Library is enabled")
    }
    override fun onDisable() {
        logger.info("Eme Library is disabled")
    }
}