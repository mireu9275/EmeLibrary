package kr.eme.plugin.emelibray.objects

import org.bukkit.command.TabExecutor

abstract class EmeCommand(val commandKey: String): TabExecutor {}