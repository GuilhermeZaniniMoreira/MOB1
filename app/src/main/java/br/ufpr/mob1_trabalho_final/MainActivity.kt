package br.ufpr.mob1_trabalho_final

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnCadastro = findViewById<Button>(R.id.btnCadastro)
        val btnExtrato = findViewById<Button>(R.id.btnExtrato)
        val btnSair = findViewById<Button>(R.id.btnSair)

        btnCadastro.setOnClickListener {
            startActivity(Intent(this, CadastroActivity::class.java))
        }

        btnExtrato.setOnClickListener {
            startActivity(Intent(this, ExtratoActivity::class.java))
        }

        btnSair.setOnClickListener {
            finish()
        }
    }
}
