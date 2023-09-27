package com.example.listadetareas

data class Task(
    val id: Int,
    val title: String,
    val completed: Boolean
)
{
    val completada: Boolean
        get() {
            TODO()
        }
    val nombre: CharSequence?
        get() {
            TODO()
        }
}

