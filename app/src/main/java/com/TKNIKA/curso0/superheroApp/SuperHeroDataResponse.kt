package com.TKNIKA.curso0.superheroApp

import com.google.gson.annotations.SerializedName

//data class reciben un parámetro como mínimo -- response viene del código JSON de la API de superhero.
// @serialzedname se utiliza para poder dar otro nombre que queramos en lugar del nombre que se le da en el JSON.
// Lo aconsejable es usar el serializedname y si no es raro y el nombre nos gusta usar el mismo nombre

data class SuperHeroDataResponse(
    @SerializedName("response") val response: String,
    @SerializedName("results") val results: List<SuperHeroItemResponse>
)

data class SuperHeroItemResponse(               //objeto para poder acceder a cada dato del listado (variable listado) de la API
    @SerializedName("id") val superHeroId: String,
    @SerializedName("name") val name: String
)