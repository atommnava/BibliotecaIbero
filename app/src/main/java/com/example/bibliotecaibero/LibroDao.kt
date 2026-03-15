package com.example.bibliotecaibero

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LibroDao {

    @Insert
    suspend fun insertarLibro(libro: Libro)

    @Query("SELECT * FROM libros")
    suspend fun obtenerLibros(): List<Libro>
}