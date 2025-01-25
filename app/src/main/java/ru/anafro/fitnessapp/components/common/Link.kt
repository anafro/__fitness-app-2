package ru.anafro.fitnessapp.components.common

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import ru.anafro.fitnessapp.navigation.NavigationRoutes

@Composable
fun Link(navHostController: NavHostController, text: String, destination: String) {
    Text(
        text,
        modifier = Modifier.Companion
            .clickable(onClick = { navHostController.navigate(destination) })
    )
}