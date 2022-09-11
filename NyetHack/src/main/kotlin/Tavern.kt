import java.io.File
import kotlin.math.roundToInt
const val TAVERN_NAME = "Taernyl's Folly"

val patronList = mutableListOf("Eli", "Mordoc", "Sophie")
val lastName = listOf("Ironfoot", "Fernsworth", "Baggins")
val uniquePatrons = mutableSetOf<String>() // прописываем тип, тк задаем пустое множество
val menuList = File("data/tavern-menu-data.txt")
                    .readText() // возвращает содержимое файла в виде строки
                    .split("\n") // разбиваем содержимое файла по символу перевода строки
val patronGold = mutableMapOf<String, Double>()
val readOnlyPatronList = patronList.toList()

fun main() {
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
//    Перебераем уникальных посетителей и кладем им по 6 золотых на счет
    uniquePatrons.forEach {
        patronGold[it] = 6.0
    }

    var orderCount = 0
    while (orderCount <= 9) {
        placeOrder(uniquePatrons.shuffled().first(),
                    menuList.shuffled().first())
        orderCount++
    }

    displayPatronBalances()
}

// Функция совершения покупки
fun performPurchase(price: Double, patronName: String) {
    val totalPurse = patronGold.getValue(patronName)
    patronGold[patronName] = totalPurse - price
    if (patronGold.getValue(patronName) <= 0) {
        uniquePatrons.remove(patronName)
        patronGold.remove(patronName)
    }
    println(patronGold)
    println(uniquePatrons)

}

// Функция вывода баланса после покупки
private fun displayPatronBalances() {
    patronGold.forEach{ patron, balance ->
        println("$patron, balance: ${"%.2f".format(balance)}")
    }
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

    performPurchase(price.toDouble(), patronName) // Оплачиваем заказ, аргумент преобразуем в числовой тип

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