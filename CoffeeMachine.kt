package machine

import kotlin.system.exitProcess 

class CoffeeMachine {

var water = 400
var milk = 540
var coffeeBeans = 120
var cups = 9
var money = 550
    
// ----------------------------------------------------------------------------------------------

fun remaining() {
    println()
    println(
            """
The coffee machine has:
$water ml of water
$milk ml of milk
$coffeeBeans g of coffee beans
$cups disposable cups
$$money of money
            """.trimIndent()
    )
    println()
}

// ----------------------------------------------------------------------------------------------

fun fill() {
    println()
    println("Write how many ml of water you want to add:")
    var waterAdd = readln().toInt()
    println("Write how many ml of milk you want to add:")
    var milkAdd = readln().toInt()
    println("Write how many grams of coffee beans you want to add:")
    var coffeeBeansAdd = readln().toInt()
    println("Write how many disposable cups you want to add:")
    var cupsAdd = readln().toInt()

    water += waterAdd
    milk += milkAdd
    coffeeBeans += coffeeBeansAdd
    cups += cupsAdd

    println()
}

// ----------------------------------------------------------------------------------------------

fun buy() {
    println()
    println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:")
    val whichCoffee = readln()

    when (whichCoffee) {
        "1" -> {
            if (water >= 250 && milk >= 0 && coffeeBeans >= 16) {
                println("I have enough resources, making you a coffee!")
                water -= 250
                milk -= 0
                coffeeBeans -= 16
                cups -= 1
                money += 4
            } else {
                println("Sorry, not enough water!")
            }
        }
        "2" -> {
            if (water >= 350 && milk >= 75 && coffeeBeans >= 20) {
                println("I have enough resources, making you a coffee!")
                water -= 350
                milk -= 75
                coffeeBeans -= 20
                cups -= 1
                money += 7
            } else {
                println("Sorry, not enough water!")
            }
        }
        "3" -> {
            if (water >= 200 && milk >= 100 && coffeeBeans >= 12) {
                println("I have enough resources, making you a coffee!")
                water -= 200
                milk -= 100
                coffeeBeans -= 12
                cups -= 1
                money += 6
            } else {
                println("Sorry, not enough water!")
            }
        }
        else -> println("Invalid!")
    }
    println()
}

// ----------------------------------------------------------------------------------------------

fun take() {
    println()
    println("I gave you $$money")
    money -= money
    println()
}

}
// ----------------------------------------------------------------------------------------------
// ----------------------------------------------------------------------------------------------


fun main() {
    val cof = CoffeeMachine()

    var inp: String
    do {
        println("Write action (buy, fill, take, remaining, exit):")
        inp = readln()
        when (inp) {
            "buy" -> cof.buy()
            "fill" -> cof.fill()
            "take" -> cof.take()
            "remaining" -> cof.remaining()
            "exit" -> exitProcess(0)
            else -> println("Invalid")
        }
    } while (true)
}
