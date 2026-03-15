package com.example.bibliotecaibero

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Libro::class], version = 1)
abstract class BibliotecaDatabase : RoomDatabase() {

    abstract fun libroDao(): LibroDao
}