package ru.anafro.fitnessapp.screens

import android.os.Bundle
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.navigation.NavHostController
import ru.anafro.fitnessapp.model.Activity

@Composable
fun ActivityDetailsScreen(navHostController: NavHostController, activity: Activity) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = activity.name,
            fontWeight = FontWeight.Bold,
            fontSize = 3.em
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text("Distance: ${activity.distance}")
        Text("Duration: ${activity.duration}")
        Text("Start Time: ${activity.startTime}")
        Text("End Time: ${activity.endTime}")
        Text("Time Ago: ${activity.timeAgo}")
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = activity.comment,
            onValueChange = { /* Update comment logic */ },
            label = { Text("Comment") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = { /* Save comment logic */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Save Comment")
        }
    }
}
