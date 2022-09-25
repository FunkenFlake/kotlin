fun main() {
    var beverage = readLine()?.let {
        if (it.isNotBlank()) {
            it.replaceFirstChar { it.uppercase() }
        } else {
            "Buttered Ale"
        }
    }

    println(beverage)

    var beverageAle = readLine()!!.replaceFirstChar { it.uppercase() }

    println(beverageAle)

    var beverageWhiskey = readLine()
//    beverageWhiskey = null

    if (beverageWhiskey != null) {
        beverageWhiskey = beverageWhiskey.replaceFirstChar { it.uppercase() }
    } else {
        println("I can't do that without crashing - beverage was null!")
    }



    val beverageServed: String = beverageWhiskey ?: "Buttered Ale"
    println(beverageServed)

//    Совмещенный вариант let и элвис
//    var beverageLast = readLine()
//    beverageLast?.let {
//        beverageLast = it.replaceFirstChar { it.uppercase() }
//    } ?: println("I can't do that wothout crashing - beverage was null!")

    var beverageLast = readLine()?.let {
        it.replaceFirstChar { it.uppercase() }
    } ?: println("I can't, bev - null")

    println(beverageLast)

}