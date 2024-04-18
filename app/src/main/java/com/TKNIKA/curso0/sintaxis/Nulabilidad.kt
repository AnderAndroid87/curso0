package com.TKNIKA.curso0.sintaxis

fun main(){
    var name: String? = null //EL signo de interrogación quiere decir que la variable es nullable

    println(name?.get(3) ?: "Es nulo cabezón")  //Si no es nulo coge la posición 3, si es nulo ejecuta lo de la derecha
}