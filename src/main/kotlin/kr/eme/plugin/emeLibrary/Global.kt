package kr.eme.plugin.emeLibrary

import kr.eme.plugin.emeLibrary.objects.EmePlugin
import org.bukkit.NamespacedKey

internal lateinit var main: EmePlugin
internal fun getNamespaceKey(key: String): NamespacedKey = NamespacedKey(main,key)