import java.util.*

fun main() {
    var beverage = readLine()?.replaceFirstChar { it.uppercase() }

    println(beverage)
}