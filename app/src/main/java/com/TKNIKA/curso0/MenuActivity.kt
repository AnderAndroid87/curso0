package com.TKNIKA.curso0

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.TKNIKA.curso0.IMCCalculator.ImcCalculatorActivity
import com.TKNIKA.curso0.TODO.TODOActivity
import com.TKNIKA.curso0.firstapp.FirstAppActivity
import com.TKNIKA.curso0.superheroApp.SuperHeroListActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val btnSaludApp = findViewById<Button>(R.id.btnSaludApp)
        val btnIMCApp = findViewById<Button>(R.id.btnIMCApp)
        val btnTODO = findViewById<Button>(R.id.btnTODO)
        val btnSuperHero = findViewById<Button>(R.id.btnsuperHero)
        btnSaludApp.setOnClickListener { navigateToSaludApp() }
        btnIMCApp.setOnClickListener { navigateToIMCApp() }
        btnTODO.setOnClickListener { navigateToTODOApp() }
        btnSuperHero.setOnClickListener { navigateTOsuperHeroApp() }
    }

    private fun navigateTOsuperHeroApp() {
        val intent = Intent (this, SuperHeroListActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToIMCApp() {
        val intent = Intent(this, ImcCalculatorActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToSaludApp(){
        val intent = Intent(this, FirstAppActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToTODOApp() {
        val intent = Intent(this, TODOActivity::class.java)
        startActivity(intent)
    }
}