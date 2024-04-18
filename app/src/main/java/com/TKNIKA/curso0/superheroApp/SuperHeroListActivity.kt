package com.TKNIKA.curso0.superheroApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import com.TKNIKA.curso0.R
import com.TKNIKA.curso0.databinding.ActivitySuperHeroListBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SuperHeroListActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySuperHeroListBinding
    private lateinit var retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuperHeroListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retrofit = getRetrofit()
        initUI()
    }

    private fun initUI() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {    //Esta función se llama automáticamente cuando pulsemos el botón de buscar
                searchByName(query.orEmpty())
                return false //Siempre se retorna un false (porque si y listo)
            }

            override fun onQueryTextChange(newText: String?) =
                //Esta función se llama automáticamente cada vez que vayamos escribiendo. No nos interesa -> ponemos return false
                false

        })
    }

    private fun searchByName(query: String) {
        binding.progressBar.isVisible = true
        CoroutineScope(Dispatchers.IO).launch { //Lo que hagamos aquí se va a ejecutar en un hilo secundario  //en un hilo secundario no se puede modificar la pantalla OJO!Para ello hay que usar runonUIthread antes
            val myresponse = retrofit.create(ApiService::class.java).getSuperheroes(query)
            Log.i("ander", "esto funciona que te cagas ;)")
            if (myresponse.isSuccessful) {
                val response: SuperHeroDataResponse? = myresponse.body()
                if (response != null) {
                    Log.i("ander", response.toString())
                    runOnUiThread {
                        binding.progressBar.isVisible = false
                    }
                }
            } else {
                Log.i("ander", "no funciona ni un cagao :(")
            }
        }
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}