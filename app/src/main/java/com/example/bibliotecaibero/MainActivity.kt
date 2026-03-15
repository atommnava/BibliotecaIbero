package com.example.bibliotecaibero

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.room.Room
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = Room.databaseBuilder(
            applicationContext,
            BibliotecaDatabase::class.java,
            "biblioteca-db"
        ).build()
        setContent {
            BibliotecaForm(db)
        }
    }
}

@Composable
fun BibliotecaForm(db: BibliotecaDatabase) {

    var titulo by remember { mutableStateOf("") }
    var autor by remember { mutableStateOf("") }
    var editorial by remember { mutableStateOf("") }
    var anio by remember { mutableStateOf("") }
    var paginas by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {

        Text("Biblioteca Ibero")

        OutlinedTextField(
            value = titulo,
            onValueChange = { titulo = it },
            label = { Text("Título") }
        )

        OutlinedTextField(
            value = autor,
            onValueChange = { autor = it },
            label = { Text("Autor") }
        )

        OutlinedTextField(
            value = editorial,
            onValueChange = { editorial = it },
            label = { Text("Editorial") }
        )

        OutlinedTextField(
            value = anio,
            onValueChange = { anio = it },
            label = { Text("Año") }
        )

        OutlinedTextField(
            value = paginas,
            onValueChange = { paginas = it },
            label = { Text("Páginas") }
        )

        Button(onClick = {

            val libro = Libro(
                titulo = titulo,
                autor = autor,
                editorial = editorial,
                anio = anio.toInt(),
                paginas = paginas.toInt()
            )

            CoroutineScope(Dispatchers.IO).launch {
                db.libroDao().insertarLibro(libro)
            }

        }) {
            Text("Guardar libro")
        }
    }
}