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
fun ProfileScreen(navHostController: NavHostController) {
    var (login, setLogin) = remember { mutableStateOf("") }
    var (nickname, setNickname) = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Профиль",
            fontWeight = FontWeight.Bold,
            fontSize = 3.em
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = login,
            onValueChange = setLogin,
            label = { Text("Логин") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = nickname,
            onValueChange = setNickname,
            label = { Text("Имя или никнейм") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = { /* TODO: Сохранить изменения */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Сохранить")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Изменить пароль",
            color = androidx.compose.ui.graphics.Color.Blue,
            modifier = Modifier
                .padding(8.dp)
                .clickable { navHostController.navigate(NavigationRoutes.CHANGE_PASSWORD) }
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = { navHostController.navigate(NavigationRoutes.AUTH) },
            modifier = Modifier.fillMaxWidth(),
            colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                containerColor = androidx.compose.ui.graphics.Color.Red
            )
        ) {
            Text("Выйти")
        }
    }
}
