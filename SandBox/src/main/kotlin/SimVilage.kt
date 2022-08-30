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
    val greetingFuncgion = {playerName: String, numBuildings: Int ->
        val currentYear = 2022
        println("Adding $numBuildings houses")
        "Welcome to SimVillage, $playerName! (c) $currentYear"
    }

    runSimulation("Guyal", greetingFuncgion)

}

fun runSimulation(playerName: String, greetingFunction: (String, Int) -> String) {
    val numBuildings = (1..3).shuffled().last()//Случайное число от 1..3
    println(greetingFunction(playerName, numBuildings))
}