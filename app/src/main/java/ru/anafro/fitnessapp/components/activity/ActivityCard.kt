package ru.anafro.fitnessapp.components.activity

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun ActivityCard(distance: String = "10 км", beganAt: String = "10:00", endedAt: String = "12:00", duration: String = "2 часа", timeAgo: String = "2 дня", activity: String = "Jogging", user: String? = null) {
    Box(
        modifier = Modifier
            .padding(24.dp)
            .border(width = 0.dp, color = Color.Transparent, shape = RoundedCornerShape(3.dp))
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column {
                Text(distance)
                Text(duration)
                Text(activity)
            }

            Column {
                Text(user ?: "")
                Text("")
                Text("${timeAgo} ago")
            }
        }
    }
}