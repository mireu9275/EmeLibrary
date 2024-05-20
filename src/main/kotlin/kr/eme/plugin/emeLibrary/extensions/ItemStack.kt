package kr.eme.plugin.emeLibrary.extensions

import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta
import org.bukkit.persistence.PersistentDataContainer

/**
 * ItemStack 에 주어진 키로 NBT 데이터가 있는지 확인합니다.
 * @receiver ItemStack
 * @param key String
 * @return Boolean
 */
fun ItemStack.hasNBT(key: String): Boolean = itemMeta.hasNBT(key)
/**
 * ItemStack 에서 주어진 키로 정수형 NBT 데이터를 가져옵니다. 데이터가 없으면 기본값을 반환합니다.
 * @receiver ItemStack
 * @param key String
 * @param defaultValue Int?
 * @return Int?
 */
fun ItemStack.getIntNBT(key: String, defaultValue: Int? = null): Int? = itemMeta.getIntNBT(key, defaultValue)
/**
 * ItemStack 에서 주어진 키로 문자열 NBT 데이터를 가져옵니다. 데이터가 없으면 기본값을 반환합니다.
 * @receiver ItemStack
 * @param key String
 * @param defaultValue String?
 * @return String?
 */
fun ItemStack.getStringNBT(key: String, defaultValue: String? = null): String? = itemMeta.getStringNBT(key, defaultValue)
/**
 * ItemStack 에 주어진 키로 정수형 NBT 데이터를 설정합니다.
 * @receiver ItemStack
 * @param key String
 * @param value Int
 */
fun ItemStack.setIntNBT(key: String, value: Int) {
    itemMeta = itemMeta.apply { setIntNBT(key, value) }
}
/**
 * ItemStack 에 주어진 키로 문자열 NBT 데이터를 설정합니다.
 * @receiver ItemStack
 * @param key String
 * @param value String
 */
fun ItemStack.setStringNBT(key: String, value: String) {
    itemMeta = itemMeta.apply { setStringNBT(key, value) }
}
/**
 * ItemStack 의 PersistentDataContainer 를 수정합니다.
 * @receiver ItemStack
 * @param block Function1<PersistentDataContainer, Unit>
 */
fun ItemStack.editCustomNBT(block: (PersistentDataContainer) -> Unit) {
    itemMeta = itemMeta.apply { editCustomNBT(block) }
}
/**
 * ItemStack 의 ItemMeta 를 수정합니다.
 * @receiver ItemStack
 * @param block Function1<ItemMeta, Unit>
 * @return ItemStack
 */
fun ItemStack.editItemMeta(block: (ItemMeta) -> Unit): ItemStack {
    itemMeta = itemMeta.apply(block)
    return this
}