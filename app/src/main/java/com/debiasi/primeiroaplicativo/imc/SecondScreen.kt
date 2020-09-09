package com.debiasi.primeiroaplicativo.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.absoluteValue

class SecondScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_screen)

        findViewById<Button>(R.id.calcular).setOnClickListener {calcularImc() }
        findViewById<Button>(R.id.go_permission).setOnClickListener {goScreenIdade() }

    }

    private fun goScreenIdade(){
        val intent = Intent(this, MainActivity::class.java).apply {

        }
        startActivity(intent);
    }

    private fun calcularImc(){

        val alturaText = findViewById<EditText>(R.id.altura)
        val pesoText = findViewById<EditText>(R.id.peso)
        val resultadoImc = findViewById<TextView>(R.id.resultado)

        val alturaString = alturaText.text.toString().trim()
        val pesoString = pesoText.text.toString().trim()

        if(alturaString != "" && pesoString != ""){
            val alturaInt = alturaString.toInt()
            val alturaFloat= alturaInt/100.toFloat()

            val pesoInt = pesoString.toInt()

            val imc = pesoInt/(alturaFloat*alturaFloat)

            if(imc<18.5){
                resultadoImc.text = "$imc Magreza"
            }
            else if (imc>=18.5 && imc<25){
                resultadoImc.text = "$imc Normal"
            }
            else if(imc >=25 && imc <30){
                resultadoImc.text = "$imc Sobrepeso"
            }
            else if(imc>=30 && imc < 40){
                resultadoImc.text = "$imc Obesidade"
            }
            else if (imc>=40){
                resultadoImc.text = "$imc Obesidade grave"
            }

        }

    }

}