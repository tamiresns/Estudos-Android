package com.example.listausuarios

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv = findViewById<RecyclerView>(R.id.rvUsuarios)

        val lista = mutableListOf<Tarefa>(
            Tarefa(nome="Tarefa 1", stack= Stack.ACADEMIA, senioridade= Periodo.MANHA),
            Tarefa(nome="Tarefa 2", stack= Stack.ALMOCO, senioridade= Periodo.TARDE),
            Tarefa(nome="Tarefa 3", stack= Stack.ESTUDO, senioridade= Periodo.NOITE)
        )
        rv.adapter = UsuarioAdapter(lista)

// Exibe os itens em uma coluna única no padrão vertical
        rv.layoutManager = LinearLayoutManager(this)

// Exibe os itens em uma coluna única no padrão horizontal
// rv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

// Exibe os itens em uma tabela com x colunas
// rv.layoutManager = GridLayoutManager(this, 2)

// Exibe os itens em uma tabela porém as células são ajustadas automaticamente de acordo com o conteúdo (Google Keep, Pintrest)
// rv.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
    }
}