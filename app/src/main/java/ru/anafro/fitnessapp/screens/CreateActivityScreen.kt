package ru.anafro.fitnessapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.navigation.NavHostController
import ru.anafro.fitnessapp.navigation.NavigationRoutes

@Composable
fun CreateActivityScreen(navHostController: NavHostController) {
    var selectedActivity by remember { mutableStateOf("Велосипед") }
    val activities = listOf("Велосипед", "Бег")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Создать активность",
            fontWeight = FontWeight.Bold,
            fontSize = 3.em
        )
        Spacer(modifier = Modifier.height(16.dp))
        activities.forEach { activity ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = (activity == selectedActivity),
                        onClick = { selectedActivity = activity }
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (activity == selectedActivity),
                    onClick = { selectedActivity = activity }
                )
                Text(text = activity, modifier = Modifier.padding(start = 8.dp))
            }
        }
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = { /* TODO: Старт активности */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Начать")
        }
    }
}