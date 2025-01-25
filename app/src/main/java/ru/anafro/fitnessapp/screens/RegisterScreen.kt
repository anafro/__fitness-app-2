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
fun RegisterScreen(navHostController: NavHostController) {
    var (login, setLogin) = remember { mutableStateOf("") }
    var (password, setPassword) = remember { mutableStateOf("") }
    var (repeatPassword, setRepeatPassword) = remember { mutableStateOf("") }
    var (name, setName) = remember { mutableStateOf("") }
    var (sex, setSex) = remember { mutableStateOf("") }

    val constraints = ConstraintSet {
        val margin = 8.dp
        val registerText = createRefFor("registerText")
        val loginField = createRefFor("loginField")
        val passwordField = createRefFor("passwordField")
        val repeatPasswordField = createRefFor("repeatPasswordField")
        val nameField = createRefFor("nameField")
        val sexField = createRefFor("sexField")
        val registerButton = createRefFor("registerButton")

        constrain(registerText) {
            top.linkTo(parent.top)
        }

        constrain(loginField) {
            top.linkTo(registerText.bottom, margin = margin)
        }

        constrain(passwordField) {
            top.linkTo(loginField.bottom, margin = margin)
        }

        constrain(repeatPasswordField) {
            top.linkTo(passwordField.bottom, margin = margin)
        }

        constrain(nameField) {
            top.linkTo(repeatPasswordField.bottom, margin = margin)
        }

        constrain(sexField) {
            top.linkTo(nameField.bottom, margin = margin)
        }

        constrain(registerButton) {
            top.linkTo(sexField.bottom, margin = margin)
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
        OutlinedTextField(
            value = repeatPassword,
            onValueChange = setRepeatPassword,
            label = { Text("Repeat password") },
            modifier = Modifier
                .layoutId("repeatPasswordField")
                .fillMaxWidth()
        )
        OutlinedTextField(
            value = name,
            onValueChange = setName,
            label = { Text("Name") },
            modifier = Modifier
                .layoutId("nameField")
                .fillMaxWidth()
        )
        OutlinedTextField(
            value = sex,
            onValueChange = setSex,
            label = { Text("Sex") },
            modifier = Modifier
                .layoutId("sexField")
                .fillMaxWidth()
        )
        Button(
            onClick = { navHostController.navigate(NavigationRoutes.ACTIVITY) },
            modifier = Modifier
                .layoutId("registerButton")
                .padding(vertical = 6.dp)
                .fillMaxWidth()
        ) {
            Text("Register to Fitness App")
        }
    }
}