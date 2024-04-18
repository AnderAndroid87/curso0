package com.TKNIKA.curso0.sintaxis

fun main() {
    getMonth(7)
    val result = getSemester(13)
    println(result)
    result(true)
}

fun result(value: Any) {
    when (value) {
        is Int -> println("entero con valor $value")
        is String -> println(value)
        is Boolean -> if (value) {
            println("Es booleano y true")
        }
    }
}

fun getSemester(month: Int)= when (month) {
        in 1..6 -> "primer semestre"
        in 7..12 -> "segundo trimestre"
        !in 1..12 -> "mes no válido"
        else -> "ouch"

}

fun getMonth(month: Int) {
    when (month) {
        1 -> println("enero")
        2 -> println("febrero")
        3 -> println("marzo")
        4 -> println("abril")
        5 -> println("mayo")
        6 -> println("junio")
        7 -> {
            println("julio")
            println("San Fermin")
        }

        else -> println("No way my friend")

    }
}