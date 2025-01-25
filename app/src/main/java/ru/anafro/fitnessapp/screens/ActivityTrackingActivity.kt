package ru.anafro.fitnessapp.screens

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.*
import org.osmdroid.api.IMapController
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.MyLocationNewOverlay
import ru.anafro.fitnessapp.ui.theme.FitnessAppTheme
import ru.anafro.fitnessapp.ui.theme.PrimaryColor

class ActivityTrackingActivity : ComponentActivity() {

    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private var locationRequest: LocationRequest? = null
    private var locationCallback: LocationCallback? = null
    private var currentLocation: Location? = null
    private var activityId: Int = 0
    private lateinit var mapView: MapView
    private lateinit var locationOverlay: MyLocationNewOverlay

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        locationRequest = LocationRequest.create().apply {
            interval = 10000
            fastestInterval = 5000
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        }

        locationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult?) {
                locationResult?.let {
                    for (location in it.locations) {
                        currentLocation = location
                        currentLocation?.let { loc ->
                            mapView.controller.setCenter(org.osmdroid.util.GeoPoint(loc.latitude, loc.longitude))
                        }
                    }
                }
            }
        }

        mapView = MapView(this)
        mapView.setTileSource(org.osmdroid.tileprovider.tilesource.TileSourceFactory.MAPNIK)
        locationOverlay = MyLocationNewOverlay(mapView)
        mapView.overlayManager.add(locationOverlay)
        mapView.setMultiTouchControls(true)

        val mapController: IMapController = mapView.controller
        mapController.setZoom(15)

        setContent {
            FitnessAppTheme {
                ActivityTrackingScreen()
            }
        }
    }

    private fun startLocationTracking(activityId: Int) {
        if (ActivityCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
        ) {
            requestLocationPermission()
        } else {
            fusedLocationClient.requestLocationUpdates(locationRequest!!, locationCallback!!, null)
        }
    }

    private fun requestLocationPermission() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
            LOCATION_PERMISSION_REQUEST_CODE
        )
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startLocationTracking(activityId)
            } else {
                MaterialAlertDialogBuilder(this)
                    .setTitle("Permission Denied")
                    .setMessage("Location permission is required for tracking your activity.")
                    .setPositiveButton("OK") { _, _ -> }
                    .show()
            }
        }
    }

    companion object {
        const val LOCATION_PERMISSION_REQUEST_CODE = 1
    }
}

@Composable
fun ActivityTrackingScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        AndroidView(
            modifier = Modifier.fillMaxSize(),
            factory = { context ->
                MapView(context).apply {
                    setTileSource(org.osmdroid.tileprovider.tilesource.TileSourceFactory.MAPNIK)
                    controller.setZoom(15)
                    controller.setCenter(org.osmdroid.util.GeoPoint(0.0, 0.0))
                    val locationOverlay = MyLocationNewOverlay(this)
                    this.overlayManager.add(locationOverlay)
                }
            }
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row {
                Text("Activity Type:", fontSize = 18.sp, color = Color.White)
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                RadioButton(
                    selected = true,
                    onClick = {},
                    modifier = Modifier.padding(8.dp)
                )
                Text("Cycling", fontSize = 16.sp, color = Color.White)
                RadioButton(
                    selected = false,
                    onClick = {},
                    modifier = Modifier.padding(8.dp)
                )
                Text("Running", fontSize = 16.sp, color = Color.White)
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                modifier = Modifier.fillMaxWidth(),
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(containerColor = PrimaryColor)
            ) {
                Text(text = "Start Activity", color = Color.White)
            }
        }
    }
}
