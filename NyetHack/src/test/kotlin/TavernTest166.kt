//import kotlin.math.roundToInt
//const val TAVERN_NAME = "Taernyl's Folly"
//const val PINTA = 0.125
//
//var playerGold = 10
//var playerSilver = 10
//var barrel = 5.0
//
//fun main() {
//    placeOrder("shandy,Dragon's Breath,5.91")
//}
//
//// Функция совершения покупки
//fun performPurchase(price: Double) {
//    displayBalance() // показываем начальный баланс
//    displayRemainderBarrel(barrel) // показываем начальный остаток в бочке
//
//    // преобразуем золото и серебро в одну валюту
//    val totalPurse = playerGold + (playerSilver / 100.0)
//    println("Total purse: $totalPurse")
//    println("Purchasing item for $price")
//
//    // показываем баланс после совершения покупки, округлив до 2х знаков после точки
//    val remainingBalance = totalPurse - price
//    println("Remaning balance: ${"%.2f".format(remainingBalance)}")
//    val remainingBalanceBarrel = barrel - PINTA
//    println("Remainder dirnk in barrel: $remainingBalanceBarrel")
//
//    // разбираем обратно нашу единую валюту (типо 4.19) на золото(4) и серебро(19)
//    val remainingGold = remainingBalance.toInt() // откидываем дробную часть
//    val remainingSilver = (remainingBalance % 1 * 100).roundToInt()
//    playerGold = remainingGold
//    playerSilver = remainingSilver
//
//    // показываем баланс после покупки
//    displayBalance()
//}
//
//// Функция для просмотра баланса
//private fun displayBalance() {
//    println("Player's purse balance: Gold: $playerGold, Silver: $playerSilver")
//}
//
//// Функция заказа напитка из меню
//private fun placeOrder(menuData: String) {
//    val indexOfApostrophe = TAVERN_NAME.indexOf('\'') // получаем индекс первого апострофа
//    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe) // возвращает новую строку
//    println("Madrigal speaks with $tavernMaster about their order.")
//
//    /** Вместо этого используем синтаксис деструктуризации
//    val data = menuData.split(',') // принимает символ разделитель и возвращает список подстрок
//    val type = data[0]
//    val name = data[1]
//    val price = data[2]
//     */
//
//    val (type, name, price) = menuData.split(',') // деструктуризация
//    val message = "Madrigal buys a $name ($type) for $price."
//    println(message)
//
//    performPurchase(price.toDouble()) // Оплачиваем заказ, аргумент преобразуем в числовой тип
//
//    val phrase = if (name == "Dragon's Breath") {
//        "Madrigal exclaims ${toDragonSpeak("Ah, delicious $name")}"
//    } else {
//        "Madrigal says: Thanks for the $name."
//    }
//    println(phrase)
//}
//
//private fun displayRemainderBarrel(barrel: Double) {
//    println("Remainder drink in barrel - $barrel")
//}
//
///** Описание phrase.replace(Regex...
// * replace принимает два аргумента. Регулярное выражение или regex, задает шаблон
// * для поиска нужных символов. Второй аргумент это анонимная функция, которая
// * определяет, какие символы необходимо заменить. *
// */
//// Функция перевода на др4к0ний я3b|к
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