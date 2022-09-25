package com.bignerdranch.nyathack
import java.io.File

class Player(_name: String,
             var healthPoints: Int = 100,
             val isBlessed: Boolean,
             private val isImmortal: Boolean) {
    var name = _name
        get() = "${field.replaceFirstChar { it.uppercase() }} of $hometown"
        private set(value) {
            field = value.trim()
        }

    val hometown by lazy { selectHometown() }
    var currentPosition = Coordinate(0, 0)

    private fun selectHometown() = File("data/towns.txt")
        .readText()
        .split("\n")
        .shuffled()
        .first()


    init {
        require(healthPoints > 0, { "healthPoints must be greater then zero."})
        require(name.isNotBlank(), { "Player must have a name."})
    }

    constructor(name: String) : this(name,
//                healthPoints = 100,
                isBlessed = true,
                isImmortal = false) {
        if (name.lowercase() == "kar") healthPoints = 40
    }

    private val minorWoundsBut = "has some minor wounds but is healing quite quickly"

    fun auraColor(): String {
        val auraVisible = isBlessed && healthPoints > 50 || isImmortal
        val auraColor = if (auraVisible) "GREEN" else "NONE"
        return auraColor
    }

    fun formatHealthStatus() =
        when (healthPoints) {
            100 -> "is in excellent condition!"
            in 90..99 -> "has a few scratches"
            in 75..89 -> if (isBlessed) minorWoundsBut else "has some minor wounds"
            in 15..74 -> "looks pretty hurt"
            else -> "is in awful condition!"
        }

    fun castFireBall(numFireBalls: Int = 2) {
        println("A glass of Fireball springs into existence. (x$numFireBalls)")
    }
}