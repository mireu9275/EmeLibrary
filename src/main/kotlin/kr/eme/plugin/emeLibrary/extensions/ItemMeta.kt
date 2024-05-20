package kr.eme.plugin.emeLibrary.extensions

import kr.eme.plugin.emeLibrary.getNamespaceKey
import org.bukkit.inventory.meta.ItemMeta
import org.bukkit.persistence.PersistentDataContainer
import org.bukkit.persistence.PersistentDataType

/**
 * ItemMeta 에 주어진 키로 NBT 데이터가 있는지 확인합니다.
 * @receiver ItemMeta
 * @param key String
 * @return Boolean
 */
fun ItemMeta.hasNBT(key: String): Boolean {
    return persistentDataContainer.has(getNamespaceKey(key), PersistentDataType.STRING)
}
/**
 * ItemMeta 에서 주어진 키로 정수형 NBT 데이터를 가져옵니다. 데이터가 없으면 기본값을 반환합니다.
 * @receiver ItemMeta
 * @param key String
 * @param defaultValue Int?
 * @return Int?
 */
fun ItemMeta.getIntNBT(key: String, defaultValue: Int? = null): Int? {
    return persistentDataContainer.get(getNamespaceKey(key), PersistentDataType.INTEGER) ?: defaultValue
}
/**
 * ItemMeta 에서 주어진 키로 문자열 NBT 데이터를 가져옵니다. 데이터가 없으면 기본값을 반환합니다.
 * @receiver ItemMeta
 * @param key String
 * @param defaultValue String?
 * @return String?
 */
fun ItemMeta.getStringNBT(key: String, defaultValue: String? = null): String? {
    return persistentDataContainer.get(getNamespaceKey(key), PersistentDataType.STRING) ?: defaultValue
}
/**
 * ItemMeta 에 주어진 키로 정수형 NBT 데이터를 설정합니다.
 * @receiver ItemMeta
 * @param key String
 * @param value Int
 */
fun ItemMeta.setIntNBT(key: String, value: Int) {
    persistentDataContainer.setInt(key, value)
}
/**
 * ItemMeta 에 주어진 키로 문자열 NBT 데이터를 설정합니다.
 * @receiver ItemMeta
 * @param key String
 * @param value String
 */
fun ItemMeta.setStringNBT(key: String, value: String) {
    persistentDataContainer.setString(key, value)
}
/**
 * ItemMeta 의 PersistentDataContainer 를 수정합니다.
 * @receiver ItemMeta
 * @param block Function1<[Error type: Unresolved type for PersistentDataContainer], Unit>
 */
fun ItemMeta.editCustomNBT(block: (PersistentDataContainer) -> Unit) {
    block(persistentDataContainer)
}