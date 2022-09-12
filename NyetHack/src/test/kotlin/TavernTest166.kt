//import kotlin.math.roundToInt
//const val TAVERT_NAME = "Taernyl's Folly"
//const val PINTA = 0.125
//
//var playerDragCoin = 5
//var playerGold = 10
//var playerSilver = 10
//var barrel = 5.0
//
//fun com.bignerdranch.nyathack.main() {
//    placeOrder("shandy,Dragon's Breath,5.91")
//
//}
//
////Функция покупки
//fun com.bignerdranch.nyathack.performPurchase(price: Double) {
//    displayBalance()
//    displayRemainderBarrel(barrel)
//
////    val totalPurse = playerGold + (playerSilver / 100.0)
//    val totalPurse = playerDragCoin * 1.43
//    println("Total purse: ${"%.4f".format(totalPurse)}")
//    println("Purchasing item for $price")
//
//    if (totalPurse >= price) {
//        val remainingBalance = (totalPurse - price) / 1.43
//        println("Remaining balance: ${"%.4f".format(remainingBalance)}")
//        val remainingBarrel = barrel - PINTA
//        println("Remainder drink in barrel: $remainingBarrel")
//
////        val remainingGold = remainingBalance.toInt()
////        val remainingSilver = (remainingBalance % 1 * 100).roundToInt()
////        playerGold = remainingGold
////        playerSilver = remainingSilver
//        barrel = remainingBarrel
//    } else {
//        println("Madrigal is don't have enough money!")
//    }
//
//    displayBalance()
//}
//
////Функция просмотра баланса
//private fun displayBalance() {
//    println("com.bignerdranch.nyathack.Player's purse balance: Gold: $playerGold, Silver: $playerSilver, Drag Coin: $playerDragCoin")
//}
//
////Функция заказа напитка из меню
//private fun placeOrder(menuData: String) {
//    val indexOfApostrophe = TAVERT_NAME.indexOf('\'')
//    val tavernMaster = TAVERT_NAME.substring(0 until indexOfApostrophe)
//    println("Madrigal speaks with $tavernMaster about their order")
//
//    val (type, name, price) = menuData.split(',')
//    val message = "Madrigal byus a $name ($type) for $price"
//    println(message)
//
//    com.bignerdranch.nyathack.performPurchase(price.toDouble())
////    com.bignerdranch.nyathack.performPurchase(price.toDouble())
//
//
//    val phrase = if (name == "Dragon's Breath") {
//        "Madrigal exclaims ${toDragonSpeak("Ah, delicious $name")}"
//    } else {
//        "Madrigal says: Thanks for the $name"
//    }
//    println(phrase)
//}
//
////Показываем остаток в бочке
//private fun displayRemainderBarrel(barrel: Double) {
//    println("Remainder drink in barrel - $barrel")
//}
//
////Функция перевода на драконий язык
//private fun toDragonSpeak(phrase: String) =
//    phrase.replace(Regex("[aeiouAEIOU]")) {
//        when (it.value) {
//            "a", "A" -> "4"
//            "e", "E" -> "3"
//            "i", "I" -> "1"
//            "o", "O" -> "0"
//            "u", "U" -> "|_|"
//            else -> it.value
//        }
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
