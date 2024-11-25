package com.example.widgets

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.glance.Button
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.GlanceTheme
import androidx.glance.action.actionStartActivity
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent
import androidx.glance.background
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.padding
import androidx.glance.text.Text

class SimpleWidgetContent : GlanceAppWidget() {

    override suspend fun provideGlance(context: Context, id: GlanceId) {

        provideContent {
            GlanceTheme {
                MyContent()
            }
        }
    }

    @Composable
    private fun MyContent() {
        Column(
            modifier = GlanceModifier.fillMaxSize()
                .background(GlanceTheme.colors.background),
            verticalAlignment = Alignment.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "¿A que pagina quieres dirigirte?", modifier = GlanceModifier.padding(12.dp))
            Column (horizontalAlignment = Alignment.CenterHorizontally) {
                Button(
                    text = "Lista de cultivos",
                    onClick = actionStartActivity<MainActivity>()
                )
                Button(
                    text = "Informacion de cultivos",
                    onClick = actionStartActivity<InformacionScreen>()
                )
                Button(
                    text = "Detalles de los cultivos",
                    onClick = actionStartActivity<DetailActivity>()
                )
            }
        }
    }
}
