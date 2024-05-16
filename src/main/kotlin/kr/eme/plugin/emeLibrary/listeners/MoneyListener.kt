package kr.eme.plugin.emeLibrary.listeners

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

object MoneyListener : Listener{
    @EventHandler
    fun onJoin(e: PlayerJoinEvent) {
        val player = e.player
        player.sendMessage("Hello")
    }
}