package com.TKNIKA.curso0.exercises

fun main(){
    val puntuacion:Int = puntosPalabra("cabbage")
    println("La puntuación de la palabra es $puntuacion")
}

fun puntosPalabra (palabra:String):Int{
    var puntuacion: Int=0
    for (indice in 0 until palabra.length){
        val letra: Char = palabra[indice]
        when (letra){
            'a','e','i','o','u','l','n','r','s','t' -> puntuacion+=1
            'd','g' -> puntuacion+=2
            'b','c','m','p' -> puntuacion+=3
            'f','h','v','w','y' -> puntuacion+=4
            'k'-> puntuacion+=5
            'j','x' -> puntuacion+=8
            'q','z' -> puntuacion+=10
        }
    }
    return puntuacion

}