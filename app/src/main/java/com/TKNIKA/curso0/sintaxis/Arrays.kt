package com.TKNIKA.curso0.sintaxis

fun main(){
    val weekDays= arrayOf("Lunes","Martes","Miércoles","Jueves","Viernes","Sábado","Domingo")

    println(weekDays.size)
    println(weekDays.last())
    for (i in weekDays.indices) {
        println(weekDays[i])
    }
    for ((position, value) in weekDays.withIndex()) {
        println(weekDays[position])
        println(value)
    }
    for (i in weekDays){
        println(i)
    }
}