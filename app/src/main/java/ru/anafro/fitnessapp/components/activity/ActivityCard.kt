package ru.anafro.fitnessapp.components.activity

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.material3.Button
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController

@Preview(showBackground = true)
@Composable
fun ActivityCard(activity: Activity, onClick: (Activity) -> Unit) {
    Box(
        modifier = Modifier
            .padding(24.dp)
            .border(width = 0.dp, color = Color.Transparent, shape = RoundedCornerShape(3.dp))
            .fillMaxWidth()
            .clickable { onClick(activity) }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column {
                Text(activity.distance)
                Text(activity.duration)
                Text(activity.activityType)
            }
            Column {
                Text(activity.username)
                Text(activity.timeAgo)
            }
        }
    }
}
