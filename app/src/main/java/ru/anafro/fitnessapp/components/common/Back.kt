package ru.anafro.fitnessapp.components.auth

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import ru.anafro.fitnessapp.navigation.NavigationRoutes

@Composable
fun Back(navHostController: NavHostController) {
    Text(
        "Back",
        modifier = Modifier.Companion
            .clickable(onClick = { navHostController.navigate(NavigationRoutes.AUTH) })
    )
}