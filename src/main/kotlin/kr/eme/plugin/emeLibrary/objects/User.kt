package kr.eme.plugin.emeLibrary.objects

import java.util.UUID

data class User(
    val uuid: UUID,
    var money: Long = 0
)