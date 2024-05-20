package kr.eme.plugin.emeLibrary.listeners

import kr.eme.plugin.emeLibrary.managers.GUIManager
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryCloseEvent
import org.bukkit.event.inventory.InventoryDragEvent

object GUIListener: Listener {
    @EventHandler
    fun onCLick(event: InventoryClickEvent) {
        GUIManager.getGUI(event.whoClicked.uniqueId)?.onClick(event)
    }
    @EventHandler
    fun onDrag(event: InventoryDragEvent) {
        GUIManager.getGUI(event.whoClicked.uniqueId)?.onDrag(event)
    }
    @EventHandler
    fun onClose(event: InventoryCloseEvent) {
        GUIManager.getGUI(event.player.uniqueId)?.onClose(event)
    }
}