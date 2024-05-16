package kr.eme.plugin.emeLibrary.objects

import org.bukkit.command.TabExecutor

abstract class EmeCommand(val commandKey: String): TabExecutor {}