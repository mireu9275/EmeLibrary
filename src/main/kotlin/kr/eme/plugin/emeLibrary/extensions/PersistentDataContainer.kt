package kr.eme.plugin.emeLibrary.extensions

import kr.eme.plugin.emeLibrary.getNamespaceKey
import org.bukkit.persistence.PersistentDataContainer
import org.bukkit.persistence.PersistentDataType

/**
 * PersistentDataContainer 에 주어진 키로 정수 값을 설정합니다.
 * @receiver PersistentDataContainer
 * @param key String
 * @param value Int
 */
fun PersistentDataContainer.setInt(key: String, value: Int) {
    set(getNamespaceKey(key), PersistentDataType.INTEGER, value)
}
/**
 * PersistentDataContainer 에 주어진 키로 문자열 값을 설정합니다.
 * @receiver PersistentDataContainer
 * @param key String
 * @param value String
 */
fun PersistentDataContainer.setString(key: String, value:String) {
    set(getNamespaceKey(key), PersistentDataType.STRING, value)
}