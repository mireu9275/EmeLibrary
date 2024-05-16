package kr.eme.plugin.emeLibrary.commands

import kr.eme.plugin.emeLibrary.main
import kr.eme.plugin.emeLibrary.managers.UserManager
import kr.eme.plugin.emeLibrary.objects.EmeCommand
import kr.eme.plugin.emeLibrary.objects.User
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import java.util.UUID

private const val TITLE = "=== 돈 명령어 ===\n"
private const val VIEW1 = "/돈 보기 : 자신이 가지고 있는 돈을 확인합니다.\n"
private const val VIEW2 = "/돈 보기 [닉네임] : [닉네임]이 가지고 있는 돈을 확인합니다.\n"
private const val SEND = "/돈 보내기 [금액] [닉네임]: [닉네임]에게 [금액]을 보냅니다.\n"
private const val WITHDRAW = "/돈 차감 [금액] [닉네임] : [닉네임]의 돈을 [금액]만큼 차감합니다.\n"
private const val DEPOSIT = "/돈 추가 [금액] [닉네임] : [닉네임]의 돈을 [금액]만큼 추가합니다.\n"
private const val SET = "/돈 설정 [금액] [닉네임] : [닉네임]의 돈을 [금액]으로 설정합니다.\n"
private const val RANK = "/돈 랭킹 : 돈 랭킹을 확인합니다.\n"
private const val UNDEFINED_ERROR = "알 수 없는 오류입니다."

object MoneyCommands : EmeCommand("money") {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) {
            sender.sendMessage("콘솔에서는 이 명령어를 사용할 수 없습니다.")
            return false
        }
        if (args.isEmpty()) {
            usage(sender)
            return true
        }
        when (args[0]) {
            "보기" -> view(sender,args)
            "보내기" -> send(sender,args)
            "추가" -> deposit(sender,args)
            "차감" -> withdraw(sender,args)
            "설정" -> set(sender,args)
            "랭킹" -> rank()
            else -> usage(sender)
        }
        return true
    }

    override fun onTabComplete(sender: CommandSender, command: Command, alias: String, args: Array<out String>): MutableList<String>? {
        return null
    }
    /**
     * Usage
     *
     * @param sender
     */
    private fun usage(sender: CommandSender) {
        sender.sendMessage(TITLE + VIEW1 + SEND)
        if(sender.isOp) sender.sendMessage(VIEW2 + DEPOSIT + WITHDRAW + SET + RANK)
    }

    private fun view(sender: CommandSender, args: Array<out String>) {
        when (args.size) {
            1 -> { // 자신의 돈 보기.
                val uuid = getUUID(sender)
                val money = getUserMoney(uuid)
                sender.sendMessage("${sender.name}님의 자산은 ${money}원 입니다.")
            }
            2 -> { // 다른사람의 돈 보기.
                TODO()
            }
        }
    }
    private fun send(sender: CommandSender, args: Array<out String>) {
        if (args.size != 3) {
            sender.sendMessage(SEND)
            return
        }
        try {
            val uuid = getUUID(sender)
            val amount = parseAmount(args[1],sender) ?: return
            val targetPlayer = getPlayer(args[2],sender) ?: return
            val targetUUID = targetPlayer.uniqueId
            UserManager.withdrawUserMoney(uuid, amount)
            UserManager.depositUserMoney(targetUUID, amount)
            sender.sendMessage("${targetPlayer.name}님에게 ${amount}원을 보냈습니다.")
        } catch (e: Exception) {
            main.warn("명령어 처리 중 오류가 발생하였습니다. ${e.message}")
            sender.sendMessage(UNDEFINED_ERROR)
        }
    }
    private fun deposit(sender: CommandSender, args: Array<out String>) {
        if (args.size != 3) {
            sender.sendMessage(DEPOSIT)
            return
        }
        try {
            val amount = parseAmount(args[1],sender) ?: return
            val targetPlayer = getPlayer(args[2],sender) ?: return
            val targetUUID = targetPlayer.uniqueId
            UserManager.depositUserMoney(targetUUID, amount)
        } catch (e: Exception) {
            main.warn("명령어 처리 중 오류가 발생하였습니다. ${e.message}")
            sender.sendMessage(UNDEFINED_ERROR)
        }
    }
    private fun withdraw(sender: CommandSender, args: Array<out String>) {
        if (args.size != 3) {
            sender.sendMessage(WITHDRAW)
            return
        }
        try {
            val amount = parseAmount(args[1],sender) ?: return
            val targetPlayer = getPlayer(args[2],sender) ?: return
            val targetUUID = targetPlayer.uniqueId
            UserManager.withdrawUserMoney(targetUUID, amount)
        } catch (e: Exception) {
            main.warn("명령어 처리 중 오류가 발생하였습니다. ${e.message}")
            sender.sendMessage(UNDEFINED_ERROR)
        }
    }
    private fun set(sender: CommandSender, args: Array<out String>) {
        if (args.size != 3) {
            sender.sendMessage(SET)
            return
        }
        try {
            val amount = parseAmount(args[1],sender) ?: return
            val targetPlayer = getPlayer(args[2],sender) ?: return
            val targetUUID = targetPlayer.uniqueId
            UserManager.setUserMoney(targetUUID, amount)
        } catch (e: Exception) {
            main.warn("명령어 처리 중 오류가 발생하였습니다. ${e.message}")
            sender.sendMessage(UNDEFINED_ERROR)
        }
    }
    private fun rank() {
        TODO()
    }

    private fun parseAmount(amountStr: String, sender: CommandSender): Long? {
        return try {
            amountStr.toLong()
        } catch (e: NumberFormatException) {
            main.warn("잘못된 금액 형식입니다 : $amountStr")
            sender.sendMessage("잘못된 금액 형식입니다 : $amountStr")
            null
        }
    }
    private fun getPlayer(playerName: String, sender: CommandSender): Player? {
        val player = Bukkit.getPlayerExact(playerName)
        if (player == null) {
            sender.sendMessage("플레이어 ${playerName}을(를) 찾을 수 없습니다.")
        }
        return player
    }
    private fun getUUID(sender: CommandSender): UUID {
        val player = sender as Player
        return player.uniqueId
    }
    private fun getUserMoney(uuid: UUID): Long = UserManager.getUserMoney(uuid)
}