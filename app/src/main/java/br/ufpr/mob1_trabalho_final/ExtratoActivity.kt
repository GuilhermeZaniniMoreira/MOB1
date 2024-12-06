package br.ufpr.mob1_trabalho_final

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class ExtratoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extrato)

        val listView = findViewById<ListView>(R.id.listViewExtrato)

        val transacoes = DataStore.obterTransacoes()

        val listaFormatada = transacoes.map {
            "${it.tipo}: ${it.descricao} - R$ ${"%.2f".format(it.valor)}"
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaFormatada)
        listView.adapter = adapter
    }
}
