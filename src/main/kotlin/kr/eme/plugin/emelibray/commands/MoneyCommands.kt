package kr.eme.plugin.emelibray.commands

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class MoneyCommands : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) {
            sender.sendMessage("콘솔에서는 이 명령어를 사용할 수 없습니다.")
            return false
        }
        when (args[0]) {
            "보기" -> TODO()
            "보내기" -> TODO()
            "추가" -> TODO()
            "차감" -> TODO()
            "설정" -> TODO()
            "랭킹" -> TODO()
            else -> usage(sender)
        }
        return true
    }
    private fun usage(sender: CommandSender) {
        sender.sendMessage(
            "=== 돈 명령어 ===\n" +
            "/돈 보기 : 자신이 가지고 있는 돈을 확인합니다." +
            "/돈 보내기 [금액] [닉네임]: [닉네임]에게 [금액]을 보냅니다."
        )
        if(sender.isOp) {
            sender.sendMessage(
                "/돈 보기 [닉네임] : [닉네임]이 가지고 있는 돈을 확인합니다." +
                "/돈 추가 [금액] [닉네임] : [닉네임]의 돈을 [금액]만큼 추가합니다." +
                "/돈 차감 [금액] [닉네임] : [닉네임]의 돈을 [금액]만큼 차감합니다." +
                "/돈 설정 [금액] [닉네임] : [닉네임]의 돈을 [금액]으로 설정합니다." +
                "/돈 랭킹 : 돈 랭킹을 확인합니다."
            )
        }
    }
}