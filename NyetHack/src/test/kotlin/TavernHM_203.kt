import java.io.File
import kotlin.math.roundToInt
const val TAVERN_NAME = "Taernyl's Folly"

var playerGold = 10
var playerSilver = 10

val patronList = mutableListOf("Eli", "Mordoc", "Sophie")
val lastName = listOf("Ironfoot", "Fernsworth", "Baggins")
val uniquePatrons = mutableSetOf<String>() // прописываем тип, тк задаем пустое множество
val menuList = File("data/tavern-menu-data-for-hm.txt")
    .readText() // возвращает содержимое файла в виде строки
    .split("\n") // разбиваем содержимое файла по символу перевода строки
val readOnlyPatronList = patronList.toList()

fun main() {

    welcomeToTavern(menuList)

    if (patronList.contains("Eli")) {
        println("The tavern master says: Eli's in the back playing cards.")
    } else {
        println("The tavern master says: Eli isn't here.")
    }

    if (patronList.containsAll(listOf("Mordoc", "Sophie"))) {
        println("The tavern master says: Yea, they're seated by the stew kettle.")
    } else {
        println("The tavern master says: Nay, they departed hours ago.")
    }

//    placeOrder("shandy,Dragon's Breath,5.91")

    /** Циклы: for, forEach, forEachIndexed
    for (patron in patronList) {
    println("Good evening, $patron")
    }

    patronList.forEach { patron ->
    println("Good evening, $patron")
    }

    patronList.forEachIndexed { index, patron ->
    println("Good evening, $patron - you're #${index + 1} in line.")
    placeOrder(patron, menuList.shuffled().first())
    }

    menuList.forEachIndexed { index, data ->
    println("$index : $data")
    }
     */

    (0..9).forEach {
        val first = patronList.shuffled().first()
        val last = lastName.shuffled().first()
        val name = "$first $last"
        uniquePatrons += name
    }

    println(uniquePatrons)

    var orderCount = 0
    while (orderCount <= 9) {
        placeOrder(uniquePatrons.shuffled().first(),
            menuList.shuffled().first())
        orderCount++
    }

}

private fun welcomeToTavern(menuData: List<String>) {
    println("*** Welcome to $TAVERN_NAME ***\n")

    menuData.forEach {
        val (_, name, price) = it.split(',')
        println("${name.replaceFirstChar { it.uppercase() }.padEnd(35, '.')}$price")
    }

}

// Функция совершения покупки
fun performPurchase(price: Double) {
    displayBalance() // показываем начальный баланс

    // преобразуем золото и серебро в одну валюту
    val totalPurse = playerGold + (playerSilver / 100.0)
    println("Total purse: $totalPurse")
    println("Purchasing item for $price")

    // показываем баланс после совершения покупки, округлив до 2х знаков после точки
    val remainingBalance = totalPurse - price
    println("Remaning balance: ${"%.2f".format(remainingBalance)}")

    // разбираем обратно нашу единую валюту (типо 4.19) на золото(4) и серебро(19)
    val remainingGold = remainingBalance.toInt() // откидываем дробную часть
    val remainingSilver = (remainingBalance % 1 * 100).roundToInt()
    playerGold = remainingGold
    playerSilver = remainingSilver

    // показываем баланс после покупки
    displayBalance()
}

// Функция для просмотра баланса
private fun displayBalance() {
    println("Player's purse balance: Gold: $playerGold, Silver: $playerSilver")
}

// Функция заказа напитка из меню
private fun placeOrder(patronName: String, menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'') // получаем индекс первого апострофа
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe) // возвращает новую строку
    println("$patronName speaks with $tavernMaster about their order.")

    /** Вместо этого используем синтаксис деструктуризации
    val data = menuData.split(',') // принимает символ разделитель и возвращает список подстрок
    val type = data[0]
    val name = data[1]
    val price = data[2]
     */

    val (type, name, price) = menuData.split(',') // деструктуризация
    val message = "$patronName buys a $name ($type) for $price."
    println(message)

//    performPurchase(price.toDouble()) // Оплачиваем заказ, аргумент преобразуем в числовой тип

    val phrase = if (name == "Dragon's Breath") {
        "$patronName exclaims ${toDragonSpeak("Ah, delicious $name")}"
    } else {
        "$patronName says: Thanks for the $name."
    }
    println(phrase)
}

/** Описание phrase.replace(Regex...
 * replace принимает два аргумента. Регулярное выражение или regex, задает шаблон
 * для поиска нужных символов. Второй аргумент это анонимная функция, которая
 * определяет, какие символы необходимо заменить. *
 */
// Функция перевода на др4к0ний я3b|к
private fun toDragonSpeak(phrase: String) =
    phrase.replace(Regex("[aeiouAEIOU]")) {
        when (it.value) {
            "a", "A" -> "4"
            "e", "E" -> "3"
            "i", "I" -> "1"
            "o", "O" -> "0"
            "u", "U" -> "|_|"
            else -> it.value
        }
    }