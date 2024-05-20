package kr.eme.plugin.emeLibrary.listeners

import kr.eme.plugin.emeLibrary.managers.UserManager
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

object MoneyListener : Listener{
    @EventHandler
    fun onJoin(e: PlayerJoinEvent) {
        val player = e.player
        val uuid = player.uniqueId
        UserManager.getUser(uuid)
    }
}