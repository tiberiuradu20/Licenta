package com.example.licenta.screens

import android.util.Log
import androidx.compose.foundation.ScrollState
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
fun antrenamentGestionatPeZile(navController: NavController, scrollState: ScrollState, profileViewModel: ProfileViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Orar de Planificare Exerciti Per Zile",
                        modifier = Modifier.padding(start = 1.dp, end = 12.dp),
                        style = TextStyle(fontSize = 19.sp, fontWeight = FontWeight.SemiBold)
                    )
                },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        modifier = Modifier.clickable {
                          //  profileViewModel.adaugamAntrenamentePerZi()
                            navController.popBackStack() }
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
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(22.dp))
            Text(
                text = "Va rugam planificati-va antrenamentele in functie de zilele saptamanii:",
                style = TextStyle(fontSize = 17.sp, fontWeight = FontWeight.SemiBold),
                modifier = Modifier.padding(12.dp)
            )

            val daysOfWeek = listOf("Luni", "Marti", "Miercuri", "Joi", "Vineri", "Sambata", "Duminica")
            val statusOptions = listOf("Unselected", "Selected", "Break Time","Set an exercise")
            val dayStatus = remember { mutableStateListOf(profileViewModel.getZiuaOrar("Luni"),
                profileViewModel.getZiuaOrar("Marti"), profileViewModel.getZiuaOrar("Miercuri"), profileViewModel.getZiuaOrar("Joi"),
                profileViewModel.getZiuaOrar("Vineri"), profileViewModel.getZiuaOrar("Sambata"), profileViewModel.getZiuaOrar("Duminica")) }

            daysOfWeek.forEachIndexed { index, day ->
                DayButton(profileViewModel=profileViewModel,navController = navController, day = day, status = dayStatus[index], statusOptions) { newStatus ->
                    dayStatus[index] = newStatus
                    profileViewModel.updateZiOrar(day,newStatus)

                }

            }
        }
    }
}

@Composable
fun DayButton(profileViewModel: ProfileViewModel, navController: NavController, day: String, status: String, statusOptions: List<String>, onStatusChange: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }

    Column {
        Button(
            onClick = { expanded = true },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = when (status) {
                    "Selected" -> Color.Green
                    "Break Time" -> Color.Red
                    else -> Color.Gray
                }
            )
        ) {
            Text(
                text = "$day: $status",
                style = TextStyle(color = Color.White, fontWeight = FontWeight.Bold, fontSize = 14.sp)
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            statusOptions.forEach { option ->
                DropdownMenuItem(onClick = {
                    onStatusChange(option)
                    expanded = false
                    if (option == "Set an exercise") {
                        profileViewModel.gestionareZile(day)
                        Log.d("Test4","$day")
                        navController.navigate("FitnessAcasa")
                    }

                }) {
                    Text(text = option)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun peZilePreview() {
    antrenamentGestionatPeZile(
        navController = rememberNavController(),
        scrollState = rememberScrollState(),
        profileViewModel = ProfileViewModel()
    )
}
