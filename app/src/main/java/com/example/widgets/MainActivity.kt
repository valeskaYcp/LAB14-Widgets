package com.example.widgets

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CropListScreen()
        }
    }
}

@Composable
fun CropListScreen() {
    val crops = listOf("Trigo", "Maíz", "Arroz")
    val context = LocalContext.current

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Lista de Cultivos", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))
        crops.forEach { crop ->
            CropItem(crop) {
                // Navegar a la pantalla de detalles
                val intent = Intent(context, DetallesScreen::class.java).apply {
                    putExtra("CROP_NAME", crop)
                }
                context.startActivity(intent)
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            // Navegar a la pantalla de información
            val intent = Intent(context, InformacionScreen::class.java)
            context.startActivity(intent)
        }) {
            Text("Información de la App")
        }
    }
}

@Composable
fun CropItem(crop: String, onClick: () -> Unit) {
    Text(
        text = crop,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = onClick),
        style = MaterialTheme.typography.bodyLarge
    )
}

