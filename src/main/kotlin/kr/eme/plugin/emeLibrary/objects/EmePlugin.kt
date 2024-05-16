package kr.eme.plugin.emeLibrary.objects

import org.bukkit.command.CommandExecutor
import org.bukkit.event.Listener
import org.bukkit.plugin.PluginManager
import org.bukkit.plugin.java.JavaPlugin
import java.util.logging.Logger

abstract class EmePlugin: JavaPlugin() {
    val pluginManager: PluginManager = server.pluginManager

    /**
     * Register events
     *
     * @param listeners
     */
    fun registerEvents(vararg listeners: Listener) {
        val pluginManager = server.pluginManager
        for (listener in listeners) {
            pluginManager.registerEvents(listener, this)
        }

    }

    /**
     * Register commands
     *
     * @param commands
     */
    fun registerCommands(vararg commands: Pair<String, CommandExecutor>) {
        for ((commandKey, command) in commands) {
            val ymlCommand = getCommand(commandKey)
            if (ymlCommand == null) {
                warn("$commandKey 명령어 설정에 실패하였습니다. (plugin.yml 에서 찾을 수 없습니다.)")
                continue
            }
            ymlCommand.setExecutor(command)
        }
    }
    fun log(block: (Logger) -> Unit) { block(logger) }
    fun warn(message: String) { logger.warning(message) }
    fun info(message: String) { logger.info(message) }
}