package kr.eme.library.extensions

import kr.eme.library.getNamespacedKey
import org.bukkit.persistence.PersistentDataContainer
import org.bukkit.persistence.PersistentDataType

fun PersistentDataContainer.setInt(key: String, value: Int) { set(getNamespacedKey(key), PersistentDataType.INTEGER, value) }
fun PersistentDataContainer.setString(key: String, value: String) { set(getNamespacedKey(key), PersistentDataType.STRING, value) }