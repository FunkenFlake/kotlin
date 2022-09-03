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
}