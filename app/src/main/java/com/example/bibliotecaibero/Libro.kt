package com.example.bibliotecaibero

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "libros")
data class Libro(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val titulo: String,
    val autor: String,
    val editorial: String,
    val anio: Int,
    val paginas: Int
)
