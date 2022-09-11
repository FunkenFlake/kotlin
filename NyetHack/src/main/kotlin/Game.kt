fun main() {
    var healthPoints = 89
    val isBlessed = true
    val isImmortal = false

    val player = Player()

//    Заклинание
    player.castFireBall()

//    Aura
    val auraColor = auraColor(isBlessed, healthPoints, isImmortal)

/*
тут написано через условный оператор, ниже через условное выражение
условное выражение присваевается переменной.

if (healthPoints == 100) {
println(name + " is in excellent condition!")
} else if (healthPoints >= 90) {
println(name + " has a few scratches.")
} else if (healthPoints >= 75) {
if (isBlessed) {
println(name + " has some minor wounds but is healing quite quickly!")
} else {
println(name + " has some minor wounds.")
}
} else if (healthPoints >= 15) {
println(name + " looks pretty hurt.")
} else {
println(name + " is in awful condition!")
} тут написано через условный оператор, ниже через условное выражение
условное выражение присваевается переменной.
*/

/*  тут написано через else if ниже переделали через when

    val healthStatus = if (healthPoints == 100) {
        "is in excellent condition!"
    } else if (healthPoints in 90..99) {
        "has a few scratches."
    } else if (healthPoints in 75..89) {
        if (isBlessed) {
            "has some minor wounds but is healing quite quickly"
        } else {
            "has some minor wounds"
        }
    } else if (healthPoints in 15..74) {
        "looks pretty hurt."
    } else {
        "is in awful condition!"
    }

   */

    val minorWoundsBut = "has some minor wounds but is healing quite quickly"
    val healthStatus = formatHealthStatus(healthPoints, isBlessed, minorWoundsBut)

//    Состояние игрока
    printPlayerStatus(auraColor, isBlessed, player.name, healthStatus)
}

private fun printPlayerStatus(
    auraColor: String,
    isBlessed: Boolean,
    name: String,
    healthStatus: String
) {
    println("(Aura: $auraColor) " + "(Blessed: ${if (isBlessed) "YES" else "NO"})")
    println("$name $healthStatus")
}

private fun auraColor(
    isBlessed: Boolean,
    healthPoints: Int,
    isImmortal: Boolean
): String {
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
    val auraColor = if (auraVisible) "GREEN" else "NONE"
    return auraColor
}

private fun formatHealthStatus(
    healthPoints: Int,
    isBlessed: Boolean,
    minorWoundsBut: String
) =
    when (healthPoints) {
        100 -> "is in excellent condition!"
        in 90..99 -> "has a few scratches"
        in 75..89 -> if (isBlessed) minorWoundsBut else "has some minor wounds"
        in 15..74 -> "looks pretty hurt"
        else -> "is in awful condition!"
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