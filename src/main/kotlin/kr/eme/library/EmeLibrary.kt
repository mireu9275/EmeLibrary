package kr.eme.library

import kr.eme.library.listeners.GUIListener
import kr.eme.library.objects.EmePlugin

class EmeLibrary : EmePlugin() {
    override fun onEnable() {
        main = this
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }

    private fun registerEvents() {
        registerEvents(
            GUIListener
        )
    }
}
