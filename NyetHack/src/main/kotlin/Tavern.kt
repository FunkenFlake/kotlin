fun main() {
    var beverage = readLine()?.let {
        if (it.isNotBlank()) {
            it.replaceFirstChar { it.uppercase() }
        } else {
            "Buttered Ale"
        }
    }

    println(beverage)
    secondOperator()
    thirdOperator()
    letPlusElvis()
}
// Второй вариант проверки на null приказной.
private fun secondOperator() {
    var beverage = readLine()!!.replaceFirstChar { it.uppercase() }
    println(beverage)
}
// Тут обычная проверка через if (kotlin тоже это понимает, поэтому
// мы не ставим операторы !!. и ?
private fun thirdOperator() {
    var beverage = readLine()
    if (beverage != null) {
        beverage.replaceFirstChar { it.uppercase() }
    } else {
        println("I can't do that without crashing - beverage is null!")
    }
//    println(beverage)
//    Оператор элвис (если beverage != null оно будет = beverageServed
//    если = null, тогда будет = "Buttered Ale"
    val beverageServed: String = beverage ?: "Buttered Ale"
    println(beverageServed)
}
// как по мне самый лучший вариант использовать let + ?:
private fun letPlusElvis() {
    var beverage = readLine()
    beverage?.let {
        beverage = it.replaceFirstChar { it.uppercase() }
    } ?: println("I can't use it, beverage is null")

//    текст выше можно сократить до:
/**    var beverage = readLine()?.let {
        it.replaceFirstChar { it.uppercase() }
    } ?: println("I can't do it, beverage is null")
    println(beverage)
*/
}

