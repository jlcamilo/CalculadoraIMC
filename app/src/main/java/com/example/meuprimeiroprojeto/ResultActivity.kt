package com.example.meuprimeiroprojeto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        //abilita a visualização do botão voltar
        supportActionBar?.setHomeButtonEnabled(true)

        //Exibe o botão voltar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // criar tvResult e tras o valor do textView pelo id
        val tvResult = findViewById<TextView>(R.id.textview_result)

        // criar tvClassificaao e tras o valor do textView pelo id
        val tvClassificacao = findViewById<TextView>(R.id.textview_classificacao)

        // recebe o valor da intent anterior
        val result = intent.getFloatExtra("EXTRA_RESULT",0.1f)

        // atribui o valor de result ao text do tvResult
        tvResult.text = result.toString()

        val classificao = if(result < 18.5f){
            "ABAIXO DO PESO"
        }else if (result in 18.5f..25.0f){
            "NORMAL"
        }else if (result in 25.0f..30.0f){
            "SOBREPESO"
        }else if (result in 30.0f..40.0f){
            "OBESIDADE"
        }else{
            "OBESIDADE GRAVE"
        }

        //Concatena a a String do tvClassificacao com texto da classificacao
        tvClassificacao.text = getString(R.string.message_classificacao,classificao)
    }

    // funçao que representa as opçoes do menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //finish fecha a tela atual
        finish()
        return super.onOptionsItemSelected(item)
    }
}