package kr.eme.library.extensions

import kr.eme.library.getNamespacedKey
import org.bukkit.inventory.meta.ItemMeta
import org.bukkit.persistence.PersistentDataContainer
import org.bukkit.persistence.PersistentDataType

fun ItemMeta.hasNBT(key: String): Boolean = persistentDataContainer.has(getNamespacedKey(key), PersistentDataType.STRING)
fun ItemMeta.getIntNBT(key: String): Int? = persistentDataContainer.get(getNamespacedKey(key), PersistentDataType.INTEGER)
fun ItemMeta.getStringNBT(key: String): String? = persistentDataContainer.get(getNamespacedKey(key), PersistentDataType.STRING)
fun ItemMeta.setIntNBT(key: String, value: Int) { persistentDataContainer.set(getNamespacedKey(key), PersistentDataType.INTEGER, value) }
fun ItemMeta.setStringNBT(key: String, value: String) { persistentDataContainer.set(getNamespacedKey(key), PersistentDataType.STRING, value) }

fun ItemMeta.editCustomNBT(block: (PersistentDataContainer) -> Unit) {
    block(persistentDataContainer)
}