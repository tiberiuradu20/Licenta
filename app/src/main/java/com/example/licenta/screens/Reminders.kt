package com.example.licenta.screens

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.licenta.ProfileViewModel

@Composable
fun reminders(navController: NavController, scrollState: ScrollState, profileViewModel: ProfileViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Workout Reminders",
                        modifier = Modifier.padding(0.dp),
                        style = TextStyle(fontSize = 19.sp, fontWeight = FontWeight.SemiBold)
                    )
                },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        modifier = Modifier.clickable { navController.popBackStack() }
                    )
                },
                backgroundColor = Color.White,
                contentColor = Color.Black,
                modifier = Modifier.fillMaxWidth()
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .verticalScroll(scrollState)
                .padding(16.dp)
        ) {
            val days = listOf("LUNI", "MARȚI", "MIERCURI", "JOI", "VINERI", "SÂMBĂTĂ", "DUMINICĂ")
            val switchStates = remember { days.map { mutableStateOf(false) } }
            val times = remember { days.map { mutableStateOf("18:30") } }

            days.forEachIndexed { index, day ->
                ReminderItem(
                    day = day,
                    switchState = switchStates[index],
                    time = times[index]
                )
                Spacer(modifier = Modifier.height(16.dp))
            }

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = { navController.popBackStack() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF6A1B9A))
            ) {
                Text(
                    text = "DONE",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun ReminderItem(day: String, switchState: MutableState<Boolean>, time: MutableState<String>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.LightGray, shape = MaterialTheme.shapes.small)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.weight(1f)
        ) {
            Switch(
                checked = switchState.value,
                onCheckedChange = { switchState.value = it }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(day, style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.SemiBold))
        }
    /*    Text(
            text = time.value,
            style = TextStyle(fontSize = 18.sp, color = Color(0xFF2979FF), fontWeight = FontWeight.Bold),
            modifier = Modifier
                .padding(start = 8.dp)
                .clickable { *//* Handle time picker dialog *//* }
        )*/
    }
}

@Preview(showBackground = true)
@Composable
fun previewReminders() {
    reminders(
        navController = rememberNavController(),
        scrollState = rememberScrollState(),
        profileViewModel = ProfileViewModel()
    )
}
