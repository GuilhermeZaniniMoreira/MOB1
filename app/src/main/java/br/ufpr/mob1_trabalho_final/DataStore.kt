package br.ufpr.mob1_trabalho_final

data class Transacao(val tipo: String, val descricao: String, val valor: Double)

object DataStore {
    val transacoes = mutableListOf<Transacao>()

    fun adicionarTransacao(transacao: Transacao) {
        transacoes.add(transacao)
    }

    fun obterTransacoes(): List<Transacao> {
        return transacoes
    }
}
