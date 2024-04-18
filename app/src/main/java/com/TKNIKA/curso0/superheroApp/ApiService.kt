package com.TKNIKA.curso0.superheroApp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("api/7411114538949290/search/{name}")
    suspend fun getSuperheroes(@Path("name") superheroName:String): Response<SuperHeroDataResponse>        //para crear corutinas (rutinas que se ejecutan fuera del hilo principal)
}