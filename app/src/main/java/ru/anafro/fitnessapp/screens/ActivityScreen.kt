package ru.anafro.fitnessapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ru.anafro.fitnessapp.components.activity.ActivityCard
import ru.anafro.fitnessapp.model.Activity

@Composable
fun ActivityScreen(navHostController: NavHostController) {
    val activities = remember { getActivities() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Activities",
            fontWeight = FontWeight.Bold,
            fontSize = 2.em
        )
        Spacer(modifier = Modifier.height(16.dp))
        
        activities.forEach { activity ->
            ActivityCard(
                activity = activity,
                onClick = {
                    navHostController.navigate("activityDetails/${activity.id}")
                }
            )
        }
    }
}
