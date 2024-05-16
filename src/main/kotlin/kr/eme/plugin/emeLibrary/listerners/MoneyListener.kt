package kr.eme.plugin.emeLibrary.listerners

import kr.eme.plugin.emeLibrary.managers.FileManager
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

object MoneyListener : Listener{
    @EventHandler
    fun onJoin(e: PlayerJoinEvent) {
        if (!FileManager.createUserConfigFile(e.player)) return
    }
}