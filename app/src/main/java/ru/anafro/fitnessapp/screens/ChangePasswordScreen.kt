package ru.anafro.fitnessapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.navigation.NavHostController
import ru.anafro.fitnessapp.navigation.NavigationRoutes

@Composable
fun ChangePasswordScreen(navHostController: NavHostController) {
    var (oldPassword, setOldPassword) = remember { mutableStateOf("") }
    var (newPassword, setNewPassword) = remember { mutableStateOf("") }
    var (confirmPassword, setConfirmPassword) = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Изменить пароль",
            fontWeight = FontWeight.Bold,
            fontSize = 3.em
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = oldPassword,
            onValueChange = setOldPassword,
            label = { Text("Старый пароль") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = newPassword,
            onValueChange = setNewPassword,
            label = { Text("Новый пароль") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = confirmPassword,
            onValueChange = setConfirmPassword,
            label = { Text("Повторите пароль") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = { navHostController.popBackStack() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Принять")
        }
    }
}
