package br.ufpr.mob1_trabalho_final

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        val edtDescricao = findViewById<EditText>(R.id.edtDescricao)
        val edtValor = findViewById<EditText>(R.id.edtValor)
        val rgTipo = findViewById<RadioGroup>(R.id.rgTipo)
        val btnSalvar = findViewById<Button>(R.id.btnSalvar)

        btnSalvar.setOnClickListener {
            val descricao = edtDescricao.text.toString()
            val valor = edtValor.text.toString().toDoubleOrNull()
            val tipoSelecionadoId = rgTipo.checkedRadioButtonId
            val tipoSelecionado = findViewById<RadioButton>(tipoSelecionadoId)?.text.toString()

            if (descricao.isNotEmpty() && valor != null && tipoSelecionadoId != -1) {
                val transacao = Transacao(tipo = tipoSelecionado, descricao = descricao, valor = valor)
                DataStore.adicionarTransacao(transacao)

                Toast.makeText(this, "Operação $tipoSelecionado cadastrada com sucesso!", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
