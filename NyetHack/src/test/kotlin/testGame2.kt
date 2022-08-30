fun main() {
    val name = "Madrigal"
    var healthPoints = 89
    val isBlessed = true
    val isImmortal = false

//    Задание со страницы 100.

//    Aura
    val auraColor = auraColor(isBlessed, healthPoints, isImmortal)

    val minorWoundsBut = "has some minor wounds but is healing quite quickly"
    val healthStatus = formatHealthStatus(healthPoints, isBlessed, minorWoundsBut)

//    Состояние игрока
    printPlayerStatus(auraColor, isBlessed, name, healthStatus)

//    Заклинание
    castFireBall(8)

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
) =
    if (isBlessed && healthPoints > 50 || isImmortal) "GREEN" else "NONE"

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

private fun castFireBall(numFireBalls: Int = 2) {
    println("A glass of Fireball springs into existence. (x$numFireBalls)")

    var effectOfDrunk = (Math.pow(Math.random(), (60 - numFireBalls) / 100.0) * 20).toInt()
    if (effectOfDrunk > 50) effectOfDrunk = 50

    val statusOfDrunk = when (effectOfDrunk) {
        in 1..10 -> "Tipsy"
        in 11..20 -> "Sloshed"
        in 21..30 -> "Soused"
        in 31..40 -> "Stewed"
        else -> "..t0aSt3d"
    }
    println("Status of Madrigal after drunk: $statusOfDrunk")
}


