const val TAVERN_NAME = "Taernyl's Folly"

fun main() {
    placeOrder("shandy,Dragon's Breath,5.91")
}

private fun placeOrder(menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'') // получаем индекс первого апострофа
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe) // возвращает новую строку
    println("Madrigal speaks with $tavernMaster about their order.")

    /** Вместо этого используем синтаксис деструктуризации
    val data = menuData.split(',') // принимает символ разделитель и возвращает список подстрок
    val type = data[0]
    val name = data[1]
    val price = data[2]
    */

    val (type, name, price) = menuData.split(',') // деструктуризация
    val message = "Madrigal buys a $name ($type) for $price."
    println(message)

    val phrase = "Ah, delicious $name!"
    println("Madrigal exclaims: ${toDragonSpeak(phrase)}")
}

/** Описание phrase.replace(Regex...
 * replace принимает два аргумента. Регулярное выражение или regex, задает шаблон
 * для поиска нужных символов. Второй аргумент это анонимная функция, которая
 * определяет, какие символы необходимо заменить. *
 */
private fun toDragonSpeak(phrase: String) =
    phrase.replace(Regex("[aeiou]")) {
        when (it.value) {
            "a" -> "4"
            "e" -> "3"
            "i" -> "1"
            "o" -> "0"
            "u" -> "|_|"
            else -> it.value
        }
    }