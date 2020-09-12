package com.debiasi.primeiroaplicativo.imc

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.verificar).setOnClickListener {verificaIdade() }
        findViewById<Button>(R.id.go_imc).setOnClickListener {goScreenImc() }

    }

    private fun goScreenImc(){
        val intent = Intent(this, SecondScreen::class.java).apply {

        }
        startActivity(intent);
    }

    private fun verificaIdade() {

        val idadeText = findViewById<EditText>(R.id.idade)
        val resultadoView = findViewById<TextView>(R.id.resultado)

        val imcButton = findViewById<Button>(R.id.go_imc)
        imcButton.visibility = View.GONE



        val idadeString = idadeText.text.toString().trim()

        if(idadeString != ""){

            val idadeNumero = idadeString.toInt()

            if(idadeNumero>= 18){
                resultadoView.text = "Acesso liberado, prossiga."
                resultadoView.setTextColor(Color.parseColor("#008000"))
                imcButton.visibility = View.VISIBLE

            }
            else{
                resultadoView.text = "Você nao tem idade suficiente para este conteúdo."
                resultadoView.setTextColor(Color.parseColor("#CC0000"))
                imcButton.visibility = View.GONE

            }
        }
        else{
            resultadoView.text="Verificação de entrada por idade."
            resultadoView.setTextColor(Color.parseColor("#747474"))
            imcButton.visibility = View.GONE
        }

    }
}
