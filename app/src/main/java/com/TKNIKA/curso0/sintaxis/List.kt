package com.TKNIKA.curso0.sintaxis

fun main (){
    inmutableList()
    mutableList()
}

fun mutableList() {
    val weekDay: MutableList <String> = mutableListOf("Lunes","Martes","Miércoles","Jueves","Viernes","Sábado","Domingo")

    weekDay.add(0,"SuperDomingo")
    println(weekDay)
}

fun inmutableList (){
    val readOnly: List <String> = listOf("Lunes","Martes","Miércoles","Jueves","Viernes","Sábado","Domingo")
    val example = readOnly.filter { it.contains("a") }
    println(readOnly.size)
    println(readOnly)
    println(readOnly.last())
    println(example)

    readOnly.forEach { weekDay -> println(weekDay) } //readOnly.forEach { println(it) }  para dar otro nombre a it, ya que así es más legible

}