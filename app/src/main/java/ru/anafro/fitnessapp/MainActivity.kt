package ru.anafro.fitnessapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.anafro.fitnessapp.ui.theme.FitnessAppTheme
import ru.anafro.fitnessapp.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FitnessAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = White
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "auth") {
        composable(route = "auth") {
            Auth(navController)
        }

        composable(route = "login") {
            Login(navController)
        }

        composable(route = "register") {
            Register(navController)
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

@Composable
fun Auth(navHostController: NavHostController) {
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
            onClick = { navHostController.navigate("login") },
            modifier = Modifier
                .layoutId("loginButton")
                .padding(vertical = 6.dp)
                .fillMaxWidth()
        ) {
            Text("Enter an account")
        }

        Button(
            onClick = { navHostController.navigate("register") },
            modifier = Modifier
                .layoutId("registerButton")
                .padding(vertical = 6.dp)
                .fillMaxWidth()
        ) {
            Text("Have no account?")
        }
    }
}

@Composable
fun Login(navHostController: NavHostController) {
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
            onClick = {},
            modifier = Modifier
                .layoutId("loginButton")
                .padding(vertical = 6.dp)
                .fillMaxWidth()
        ) {
            Text("Log In to Fitness App")
        }
    }
}

@Composable
fun Register(navHostController: NavHostController) {
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
            onClick = {},
            modifier = Modifier
                .layoutId("registerButton")
                .padding(vertical = 6.dp)
                .fillMaxWidth()
        ) {
            Text("Register to Fitness App")
        }
    }
}

@Composable
fun Back(navHostController: NavHostController) {
    Text(
        "Back",
        modifier = Modifier
            .clickable(onClick = { navHostController.navigate("auth") })
    )
}