package kr.eme.library.objects

import kr.eme.library.coroutine.sync
import kr.eme.library.managers.GUIManager
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryCloseEvent
import org.bukkit.event.inventory.InventoryDragEvent
import org.bukkit.event.inventory.InventoryType
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack

abstract class GUI {

    val player: Player
    val size: Int
    private val inventory: Inventory

    constructor(player: Player, title: String, row: Int) {
        this.player = player
        this.size = row * 9
        inventory = Bukkit.createInventory(null, size, title)
    }

    constructor(player: Player, title: String, type: InventoryType) {
        this.player = player
        this.size = type.defaultSize
        inventory = Bukkit.createInventory(null, type, title)
    }

    fun getItem(slot: Int): ItemStack? = inventory.getItem(slot)
    fun setItem(slot: Int, itemStack: ItemStack?) = inventory.setItem(slot, itemStack)
    fun clear() {
        for (slot in 0 until size) {
            setItem(slot,null)
        }
    }

    fun firstOpen() {
        setFirstGUI()
        open()
    }

    private fun open() {
        sync {
            player.closeInventory()
            GUIManager.setGUI(player.uniqueId, this@GUI)
            player.openInventory(inventory)
        }
    }

    fun close() {
        sync { player.closeInventory() }
    }

    fun onClick(event: InventoryClickEvent) { event.clickEvent() }
    fun onDrag(event: InventoryDragEvent) { event.dragEvent() }
    fun onClose(event: InventoryCloseEvent) { event.closeEvent() }

    abstract fun setFirstGUI()
    abstract fun InventoryClickEvent.clickEvent()
    abstract fun InventoryDragEvent.dragEvent()
    abstract fun InventoryCloseEvent.closeEvent()
}
