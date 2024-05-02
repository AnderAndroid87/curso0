package com.TKNIKA.curso0.exercises

fun main() {
    val sentence1: String = "The quick brown fox jumps over the lazy dog."
    val sentence2: String = "This is crazy man"
    if (pangram(sentence1)){
        println("Excelente, es un pangrama!")
    }else{
        println("Vaya, no es un pangrama!")
    }
}

fun pangram(sentence: String): Boolean {
    val alphabet = BooleanArray(26) { false }
    var totalTrue = 0
    for (i in sentence.lowercase()) {
        if (i in 'a'..'z'){
            val index = i - 'a'
            alphabet[index] = true
        }
    }
    totalTrue = alphabet.count {it}
    return totalTrue == alphabet.size
}