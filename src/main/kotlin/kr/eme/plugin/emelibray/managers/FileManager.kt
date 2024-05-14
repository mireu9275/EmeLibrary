package kr.eme.plugin.emelibray.managers

import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File
import java.io.IOException

object FileManager {
    @Throws(IOException::class)
    fun loadOrCreateConfig(file: File): FileConfiguration {
        if (!file.exists()) {
            file.parentFile.mkdirs()
            file.createNewFile()
        }
        return YamlConfiguration.loadConfiguration(file)
    }
}