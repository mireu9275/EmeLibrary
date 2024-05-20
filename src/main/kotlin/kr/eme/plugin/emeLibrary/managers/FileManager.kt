package kr.eme.plugin.emeLibrary.managers

import org.yaml.snakeyaml.DumperOptions
import org.yaml.snakeyaml.Yaml
import java.io.File

class FileManager<T>(private val clazz: Class<T>, val directory: File) {
    init {
        if (!directory.exists()) {
            directory.mkdirs()
        }
    }
    private fun getFile(fileName: String): File {
        return File(directory, fileName)
    }
    fun load(fileName: String): T? {
        val file = getFile(fileName)
        if (!file.exists()) return null
        val yaml = Yaml()
        return yaml.loadAs(file.readText(), clazz)
    }
    fun save(fileName: String, data: T) {
        val file = getFile(fileName)
        val option = DumperOptions().apply {
            defaultFlowStyle = DumperOptions.FlowStyle.BLOCK
        }
        val yaml = Yaml(option)
        file.writeText(yaml.dump(data))
    }
    fun reload(fileName: String): T? {
        return load(fileName)
    }
}