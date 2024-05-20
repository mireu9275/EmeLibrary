package kr.eme.plugin.emeLibrary.managers

import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta

object ItemStackUtil {
    fun build(material: Material, block: (ItemMeta) -> Unit): ItemStack {
        val item = ItemStack(material)
        val meta = item.itemMeta
        block(meta)
        item.itemMeta = meta
        return item
    }
    fun build(material: Material, block:(ItemStack,ItemMeta) -> Unit): ItemStack {
        val item = ItemStack(material)
        val meta = item.itemMeta
        block(item, meta)
        item.itemMeta = meta
        return item
    }
}