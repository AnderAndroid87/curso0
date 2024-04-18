package com.TKNIKA.curso0.sintaxis

/**
 * Variables
 */

fun main() {

    showMyName ("Mivhel")

    val number: Int = 5
    val longNumber: Long = 4000000
    val floatNumber: Float = 30.5f
    val doubleNumber: Double = 30555.78

    val charExample: Char = 'd'
    val stringExample: String = "Pedro"

    val boolExample: Boolean = true

    var numberExample: Int

    numberExample = 35
    print(numberExample)

    var suma: Int = number + floatNumber.toInt()
    print(suma)
    print("Hola me llamo $stringExample")

}

fun showMyName (name:String){
    println("Hola me llamo $name")
}