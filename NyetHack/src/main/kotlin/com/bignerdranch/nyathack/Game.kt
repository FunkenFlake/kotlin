package com.bignerdranch.nyathack

fun main() {
    val player = Player()

//    Заклинание
    player.castFireBall()

//    Состояние игрока
    printPlayerStatus(player)
}

//    Функция требует только экзепляр класса com.bignerdranch.nyathack.Player, в нем всё и содержится.
private fun printPlayerStatus(player: Player) {
    println("(Aura: ${player.auraColor()}) " + "(Blessed: ${if (player.isBlessed) "YES" else "NO"})")
    println("${player.name} ${player.formatHealthStatus()}")
}

/*  Самопальная драка
//    Fight!
    val fight = fightPlayer(healthPoints)
    println("$name after fight. (HP: $fight)")
    println("$healthStatus")

}

private fun fightPlayer(healthPoints: Int): Int {
    var hit = (Math.pow(Math.random(), (110 - healthPoints) / 100.0) * 20).toInt()
    var healthAfterFight = healthPoints - (hit * 3)
    println(hit)
    return healthAfterFight
}
 */