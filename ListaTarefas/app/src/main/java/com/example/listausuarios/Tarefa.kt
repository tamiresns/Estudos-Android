package com.example.listausuarios
import android.graphics.drawable.Drawable

data class Tarefa(
        var foto: Drawable?=null,
        var nome: String,
        var stack: Stack,
        var senioridade: Periodo
)