package kr.eme.plugin.emeLibrary.objects

data class Message(
    var title: String = "=== 돈 명령어 ===\n",
    var view1: String = "/돈 보기 : 자신이 가지고 있는 돈을 확인합니다.\n",
    var view2: String = "/돈 보기 [닉네임] : [닉네임]이 가지고 있는 돈을 확인합니다.\n",
    var send: String = "/돈 보내기 [금액] [닉네임]: [닉네임]에게 [금액]을 보냅니다.\n",
    var withdraw: String = "/돈 차감 [금액] [닉네임] : [닉네임]의 돈을 [금액]만큼 차감합니다.\n",
    var deposit: String = "/돈 추가 [금액] [닉네임] : [닉네임]의 돈을 [금액]만큼 추가합니다.\n",
    var set: String = "/돈 설정 [금액] [닉네임] : [닉네임]의 돈을 [금액]으로 설정합니다.\n",
    var rank: String  = "/돈 랭킹 : 돈 랭킹을 확인합니다.\n",
    var undefinedError: String = "알 수 없는 오류입니다."
)   