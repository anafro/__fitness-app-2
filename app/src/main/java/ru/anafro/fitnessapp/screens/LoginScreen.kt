package ru.anafro.fitnessapp.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.navigation.NavHostController
import ru.anafro.fitnessapp.components.auth.Back
import ru.anafro.fitnessapp.navigation.NavigationRoutes

@Composable
fun LoginScreen(navHostController: NavHostController) {
    var (login, setLogin) = remember { mutableStateOf("") }
    var (password, setPassword) = remember { mutableStateOf("") }

    val constraints = ConstraintSet {
        val margin = 8.dp
        val registerText = createRefFor("registerText")
        val loginField = createRefFor("loginField")
        val passwordField = createRefFor("passwordField")
        val loginButton = createRefFor("loginButton")

        constrain(registerText) {
            top.linkTo(parent.top)
        }

        constrain(loginField) {
            top.linkTo(registerText.bottom, margin = margin)
        }

        constrain(passwordField) {
            top.linkTo(loginField.bottom, margin = margin)
        }

        constrain(loginButton) {
            top.linkTo(passwordField.bottom, margin = margin)
        }
    }

    ConstraintLayout(
        constraintSet = constraints,
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
    ) {
        Back(navHostController)
        Text(
            "Register",
            fontWeight = FontWeight.Bold,
            fontSize = 3.em,
            modifier = Modifier
                .layoutId("registerText")
        )
        OutlinedTextField(
            value = login,
            onValueChange = setLogin,
            label = { Text("Login") },
            modifier = Modifier
                .layoutId("loginField")
                .fillMaxWidth()
        )
        OutlinedTextField(
            value = password,
            onValueChange = setPassword,
            label = { Text("Password") },
            modifier = Modifier
                .layoutId("passwordField")
                .fillMaxWidth()
        )
        Button(
            onClick = { navHostController.navigate(NavigationRoutes.ACTIVITY) },
            modifier = Modifier
                .layoutId("loginButton")
                .padding(vertical = 6.dp)
                .fillMaxWidth()
        ) {
            Text("Log In to Fitness App")
        }
    }
}