fun main() {
    val name = "Madrigal"
    var healthPoints = 89
    val isBlessed = true
    val isImmortal = false

//    Aura
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal


//    Karma
    val karma = (Math.pow(Math.random(), (110 - healthPoints) / 100.0) * 20).toInt()
    val auraColor = when (karma) {
        in 0..5 -> "RED"
        in 6..10 -> "ORANGE"
        in 11..15 -> "PURPLE"
        else -> "GREEN"
    }

    val minorWoundsBut = "has some minor wounds but is healing quite quickly"
    val healthStatus = when (healthPoints) {
        100 -> "is in excellent condition!"
        in 90..99 -> "has a few scratches"
        in 75..89 -> if (isBlessed) minorWoundsBut else "has some minor wounds"
        in 15..74 -> "looks pretty hurt"
        else -> "is in awful condition!"
    }

//    Строка состояния
    val B = "Blessed: ${if (isBlessed) "YES" else "NO"}"
    val A = "Aura: $auraColor"
    val H = "$name $healthStatus"
    val HP = "HP: $healthPoints"

    val statusFormatString = "($HP) ($A) ($B) -> $H"
    println(statusFormatString)

}