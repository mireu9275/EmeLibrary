package kr.eme.library.objects

import kr.eme.library.main
import org.bukkit.event.Listener
import org.bukkit.plugin.PluginManager
import org.bukkit.plugin.java.JavaPlugin
import java.util.logging.Logger

abstract class EmePlugin: JavaPlugin() {
    private val pluginManager: PluginManager = server.pluginManager

    /**
     * Register evenets
     *
     * @param listeners
     */
    fun registerEvents(vararg listeners: Listener) {
        val pluginManager = server.pluginManager
        for (listener in listeners) {
            pluginManager.registerEvents(listener, main)
        }
    }

    /**
     * Register commands
     *
     * @param commands
     */
    fun registerCommands(vararg commands: EmeCommand) {
        for (command in commands) {
           val commandKey = command.commandKey
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