package com.example.fitnessapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.LiveData
import androidx.navigation.NavHostController
import com.example.fitnessapp.database.Activity
import com.example.fitnessapp.viewmodel.ActivityViewModel

@Composable
fun ActivityScreen(navHostController: NavHostController, viewModel: ActivityViewModel = viewModel()) {
    val activities: LiveData<List<Activity>> = viewModel.getAllActivities()
    val activityList by activities.observeAsState(emptyList())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "My Activities",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(activityList) { activity ->
                ActivityCard(activity = activity, navHostController = navHostController)
            }
        }
    }
}