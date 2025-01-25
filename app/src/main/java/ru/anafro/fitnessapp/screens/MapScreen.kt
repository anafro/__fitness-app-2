package ru.anafro.fitnessapp.screens

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import org.osmdroid.api.IMapController
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.MyLocationNewOverlay
import org.osmdroid.util.GeoPoint
import ru.anafro.fitnessapp.ui.theme.FitnessAppTheme
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun MapScreen(navController: NavController) {
    var isStarted by remember { mutableStateOf(false) }
    var activityType by remember { mutableStateOf(ActivityType.RUNNING) }
    var timeElapsed by remember { mutableStateOf(0L) }
    var kilometers by remember { mutableStateOf(0f) }
    var isPaused by remember { mutableStateOf(false) }

    val playPauseIcon = if (isPaused) Icons.Filled.PlayArrow else Icons.Filled.Pause

    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.weight(1f)) {
            AndroidView(
                modifier = Modifier.fillMaxSize(),
                factory = { context ->
                    MapView(context).apply {
                        setTileSource(org.osmdroid.tileprovider.tilesource.TileSourceFactory.MAPNIK)
                        controller.setZoom(15)

                        val locationOverlay = MyLocationNewOverlay(this)
                        this.overlayManager.add(locationOverlay)
                        locationOverlay.enableMyLocation()
                        val initialPoint = GeoPoint(51.505, -0.09)
                        val mapController: IMapController = controller
                        mapController.setCenter(initialPoint)
                    }
                }
            )
        }

        Column(modifier = Modifier.padding(16.dp)) {
            Row(modifier = Modifier.selectableGroup()) {
                RadioButton(
                    selected = activityType == ActivityType.RUNNING,
                    onClick = { activityType = ActivityType.RUNNING },
                    colors = RadioButtonDefaults.colors(selectedColor = Color.Blue)
                )
                Text("Running", fontSize = 16.sp)
                Spacer(modifier = Modifier.width(16.dp))
                RadioButton(
                    selected = activityType == ActivityType.CYCLING,
                    onClick = { activityType = ActivityType.CYCLING },
                    colors = RadioButtonDefaults.colors(selectedColor = Color.Blue)
                )
                Text("Cycling", fontSize = 16.sp)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    isStarted = true
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Start", fontSize = 16.sp)
            }

            if (isStarted) {
                Spacer(modifier = Modifier.height(16.dp))
                Text("Activity Type: ${activityType.name}", fontSize = 16.sp)
                Text("Time: ${formatTime(timeElapsed)}", fontSize = 16.sp)
                Text("Distance: $kilometers km", fontSize = 16.sp)

                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                    IconButton(onClick = {
                        isPaused = !isPaused
                    }) {
                        Icon(playPauseIcon, contentDescription = null)
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    IconButton {
                        Icon(Icons.Filled.CheckCircle, contentDescription = null)
                    }
                }
            }
        }
    }
}

enum class ActivityType {
    RUNNING, CYCLING
}

fun formatTime(time: Long): String {
    return String.format("%02d:%02d:%02d", time / 3600, (time % 3600) / 60, time % 60)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FitnessAppTheme {
        MapScreen(navController = NavController(context = LocalContext.current))
    }
}
