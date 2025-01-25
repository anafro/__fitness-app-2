package ru.anafro.fitnessapp.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.navigation.NavHostController
import ru.anafro.fitnessapp.navigation.NavigationRoutes


@Composable
fun AuthScreen(navHostController: NavHostController) {
    val constraints = ConstraintSet {
        val margin = 8.dp
        val loginButton = createRefFor("loginButton")
        val registerButton = createRefFor("registerButton")

        constrain(loginButton) {
            top.linkTo(parent.top)
        }

        constrain(registerButton) {
            top.linkTo(loginButton.bottom, margin = margin)
        }
    }

    ConstraintLayout(
        constraintSet = constraints,
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
    ) {
        Button(
            onClick = { navHostController.navigate(NavigationRoutes.LOGIN) },
            modifier = Modifier
                .layoutId("loginButton")
                .padding(vertical = 6.dp)
                .fillMaxWidth()
        ) {
            Text("Enter an account")
        }

        Button(
            onClick = { navHostController.navigate(NavigationRoutes.REGISTER) },
            modifier = Modifier
                .layoutId("registerButton")
                .padding(vertical = 6.dp)
                .fillMaxWidth()
        ) {
            Text("Have no account?")
        }
    }
}