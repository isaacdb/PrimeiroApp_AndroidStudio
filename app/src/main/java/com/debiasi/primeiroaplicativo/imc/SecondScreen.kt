package com.debiasi.primeiroaplicativo.imc

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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
        val dica = findViewById<TextView>(R.id.dicas)

        val alturaString = alturaText.text.toString().trim()
        val pesoString = pesoText.text.toString().trim()

        if(alturaString != "" && pesoString != ""){
            val alturaInt = alturaString.toInt()
            val alturaFloat= alturaInt/100.toFloat()

            val pesoInt = pesoString.toInt()

            val imc = pesoInt/(alturaFloat*alturaFloat)

            if(imc<18.5){
                resultadoImc.text = "$imc Magreza"
                resultadoImc.setTextColor(Color.parseColor("#FFD700"))
                dica.text = "Voce está a baixo do peso ideal,busque um profissional adequado para verificar se sua esta sendo afetada de alguma maneira."
            }
            else if (imc>=18.5 && imc<25){
                resultadoImc.text = "$imc Normal"
                resultadoImc.setTextColor(Color.parseColor("#00FF00"))
                dica.text = "Voce está no seu peso ideal, porem nao deixe de manter uma vida saudável!"

            }
            else if(imc >=25 && imc <30){
                resultadoImc.text = "$imc Sobrepeso"
                resultadoImc.setTextColor(Color.parseColor("#FF8C00"))
                dica.text = "Voce está a cima do seu peso ideal, procure um profissional para lhe auxiliar a manter a saude, e evitar possiveis doenças."
            }
            else if(imc>=30 && imc < 40){
                resultadoImc.text = "$imc Obesidade"
                resultadoImc.setTextColor(Color.parseColor("#FF0000"))
                dica.text = "Você esta em nivel de Obesidade, procure um especialista com urgência. Obesidade trazem doenças como diabetes, hipertensão, infarto e varios tipos de câncer."

            }
            else if (imc>=40){
                resultadoImc.text = "$imc Obesidade grave"
                resultadoImc.setTextColor(Color.parseColor("#8B0000"))
                dica.text = "Você esta em nivel de Obesidade Morbida, grau extremamente perigoso, agravamento de varias doenças. Procure imediatamente um médico."

            }
            dica.visibility = View.VISIBLE
        }
        else{
            dica.visibility = View.GONE
        }

    }

}