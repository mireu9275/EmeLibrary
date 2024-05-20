package kr.eme.plugin.emeLibrary.managers

import kr.eme.plugin.emeLibrary.main
import org.bukkit.Bukkit
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import java.util.*

object UtilManager {
    /**
     * Parse amount
     *
     * 주어진 문자열을 Long 타입으로 변환함. 실패시 null 반환
     * @param amountStr
     * @param sender
     * @return
     */
    fun parseAmount(amountStr: String, sender: CommandSender): Long? {
        return try {
            amountStr.toLong()
        } catch (e: NumberFormatException) {
            main.warn("잘못된 금액 형식입니다 : $amountStr")
            sender.sendMessage("잘못된 금액 형식입니다 : $amountStr")
            null
        }
    }
    /**
     * Get player
     *
     * 주어진 플레이어 이름으로 접속중인 플레이어를 찾음. 실패시 null 반환
     * @param playerName
     * @param sender
     * @return
     */
    fun getPlayer(playerName: String, sender: CommandSender): Player? {
        val player = Bukkit.getPlayerExact(playerName)
        if (player == null) {
            sender.sendMessage("플레이어 ${playerName}을(를) 찾을 수 없습니다.")
        }
        return player
    }
    /**
     * Get uuid
     *
     * 커맨드를 입력한 플레이어의 UUID 를 반환함.
     * @param sender
     * @return
     */
    fun getUUID(sender: CommandSender): UUID {
        val player = sender as Player
        return player.uniqueId
    }
}