package com.bignerdranch.nyathack

fun main() {
    var swordsJuggling: Int? = null
    val isJugglingProficient = (1..3).shuffled().last() == 3
    println(isJugglingProficient)
    if (isJugglingProficient) {
        swordsJuggling = 2
    }

    try {
        proficiencyCheck(swordsJuggling)
        swordsJuggling = swordsJuggling!!.plus(1)
    } catch (e: Exception) { // перехватываем все исключения типа Exception
        println(e)
    }

    println("You juggle $swordsJuggling swords")

}

fun proficiencyCheck(swordsJuggling: Int?) {
//    swordsJuggling ?: throw com.bignerdranch.nyathack.UnskilledSwordJugglerException()
    checkNotNull(swordsJuggling, {"com.bignerdranch.nyathack.Player cannot juggle swords"}) //(значение для проверки, {сообщение об ошибке})
}

class UnskilledSwordJugglerException() :
        IllegalStateException("com.bignerdranch.nyathack.Player cannot juggle swords")