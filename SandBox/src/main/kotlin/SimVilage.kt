import kotlin.reflect.KFunction0

/*fun main() {
    val greetingFunction: (String, Int)/*Тип параметра*/ -> String/*Тип выходного значения*/ = { playerName/*Сам параметр*/, numBuildings ->
//    val greetingFunction: (String) -> String = {/*Не указываем параметр, используем it*/
        val currentYear = 2022
        println("Adding $numBuildings houses")
        "Welcome to SimVillage, $playerName! (c) $currentYear"//$playerName вызов параметра
    }

    println(greetingFunction("Guyal"/*Передача аргумента параметру playerName*/, 2))
}

 */

fun main() {
    runSimulation("Guyal", ::printConstructionCost) {playerName, numBuildings ->
        val currentYear = 2022
        println("Adding $numBuildings houses")
        "Welcome to SimVillage, $playerName! (c) $currentYear"
    }

    someFunction(::printSomeFunction, "yes, it's works!")



}

inline fun runSimulation(playerName: String,
                         costPrinter: (Int) -> Unit,
                         greetingFunction: (String, Int) -> String) {
    val numBuildings = (1..3).shuffled().last()//Случайное число от 1..3
    costPrinter(numBuildings)
    println(greetingFunction(playerName, numBuildings))
}

fun printConstructionCost(numBuildings: Int) {
    val cost = 500
    println("construction cost: ${cost * numBuildings}")
}

fun someFunction(printSome: (String) -> Unit, someText: String) {
    printSome(someText)
}

fun printSomeFunction(someText: String) {
    println(someText)
}

