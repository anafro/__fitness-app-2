package ru.anafro.fitnessapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.anafro.fitnessapp.navigation.NavigationRoutes
import ru.anafro.fitnessapp.screens.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FitnessAppTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    App()
                }
            }
        }
    }

    @Composable
    fun App() {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = NavigationRoutes.ACTIVITY) {
            composable(route = NavigationRoutes.AUTH) {
                AuthScreen(navController)
            }

            composable(route = NavigationRoutes.LOGIN) {
                LoginScreen(navController)
            }

            composable(route = NavigationRoutes.REGISTER) {
                RegisterScreen(navController)
            }

            composable(route = NavigationRoutes.ACTIVITY) {
                ActivityScreen(navController)
            }

            composable(route = "activityDetails/{activityId}") { backStackEntry ->
                val activityId = backStackEntry.arguments?.getString("activityId") ?: ""
                val activity = getActivityById(activityId)
                ActivityDetailsScreen(navHostController = navController, activity = activity)
            }

            composable(route = NavigationRoutes.CHANGE_PASSWORD) {
                ChangePasswordScreen(navController)
            }

            composable(route = NavigationRoutes.PROFILE) {
                ProfileScreen(navController)
            }

            composable(route = NavigationRoutes.CREATE_ACTIVITY) {
                CreateActivityScreen(navController)
            }
        }
    }
}
