package kr.eme.plugin.emelibray

import org.bukkit.NamespacedKey
import org.bukkit.plugin.java.JavaPlugin

internal lateinit var main: JavaPlugin
internal fun getNamespaceKey(key: String): NamespacedKey = NamespacedKey(main,key)