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
    runSimulation()
}

fun runSimulation() {
    val greetingFunction = configureGreetingFunction()
    println(greetingFunction("Gyual"))
    println(greetingFunction("Gyual"))
    println(greetingFunction("Gyual"))
}

fun configureGreetingFunction(): (String) -> String {
    val structureType = "hospitals"
    var numBuildings = 5
    return {playerName: String ->
        val currentYear = 2022
        numBuildings += 1
        println("Adding $numBuildings $structureType")
        "Welcome to SimVillage, $playerName! (c) $currentYear"
    }
}
