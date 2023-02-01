package com.example.meuprimeiroprojeto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Refayo lerencia o layout
        setContentView(R.layout.activity_main)

        // variavel para recuperar o botão atraves da ID
        val btnCalcular: Button = findViewById(R.id.btnCalcular)

        // variavel para recuperar o peso atraves da ID
        val edtPeso: EditText = findViewById(R.id.edt_Peso)

        // variavel para recuperar a altura atraves da ID
        val edtAltura: EditText = findViewById(R.id.edt_altura)

        // funcão que "escuta" o click do botão
        btnCalcular.setOnClickListener {

            //Recebe o valor de pesso e altura como String
            val alturaString = edtAltura.text.toString()
            val pesoString = edtPeso.text.toString()

            // Trata os erros (verifica se os valores estão vazios )
            if (alturaString.isNotEmpty() && pesoString.isNotEmpty()){

                val altura:Float = alturaString.toFloat()
                val peso: Float = pesoString.toFloat()

                val alturaFinal: Float = altura * altura
                val result: Float = peso/alturaFinal


                // Abre ua proxima tela
                val intent = Intent(this, ResultActivity::class.java)

                    .apply {
                        //chama a proxima tela passando um valor ("CHAVE",valor)
                        putExtra("EXTRA_RESULT",result)
                    }
                startActivity(intent)
            }else{
                Toast.makeText(this,"Preencher todos os campos",Toast.LENGTH_LONG).show()
            }

        }
    }
}