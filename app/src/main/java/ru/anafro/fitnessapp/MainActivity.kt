import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.anafro.fitnessapp.navigation.NavigationRoutes
import ru.anafro.fitnessapp.screens.ActivityScreen
import ru.anafro.fitnessapp.screens.AuthScreen
import ru.anafro.fitnessapp.screens.LoginScreen
import ru.anafro.fitnessapp.screens.RegisterScreen
import ru.anafro.fitnessapp.ui.theme.FitnessAppTheme
import ru.anafro.fitnessapp.ui.theme.*

class MainActivity : ComponentActivity() {
    @Composable
    fun App() {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = NavigationRoutes.AUTH) {
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