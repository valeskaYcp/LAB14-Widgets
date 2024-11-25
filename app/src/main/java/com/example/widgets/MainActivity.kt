package com.example.widgets


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class DetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val cropName = intent.getStringExtra("CROP_NAME") ?: "Cultivo desconocido"
        setContent {
            CropDetailScreen(cropName)
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CropDetailScreen(cropName: String) {
    Scaffold(topBar = {
        TopAppBar(title = { Text("Detalles del Cultivo") })
    }) {
        Column(modifier = Modifier.padding(16.dp)) {
            Spacer(modifier = Modifier.height(42.dp))
            CropInfoCard("Trigo", "Cultivo de cereal básico para la producción de harina.")
            CropInfoCard("Maíz", "Cultivo clave para alimentos, forrajes y bioenergía.")
            CropInfoCard("Arroz", "Principal fuente de alimento en muchas culturas.")
        }
    }
}

@Composable
fun CropInfoCard(cropName: String, description: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(cropName, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text(description, style = MaterialTheme.typography.bodyMedium)
        }
    }
}
