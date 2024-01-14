package kr.eme.library.managers

import kr.eme.library.objects.GUI
import java.util.UUID

object GUIManager {
    private val guiMap = HashMap<UUID, GUI>()
    fun getGUI(uuid: UUID): GUI? = guiMap[uuid]
    fun setGUI(uuid: UUID, gui: GUI) { guiMap[uuid] = gui }
    fun removeGUI(uuid: UUID) { guiMap.remove(uuid) }
}