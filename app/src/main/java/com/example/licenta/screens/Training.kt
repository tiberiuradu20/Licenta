package com.example.licenta.screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.licenta.ProfileViewModel
import com.example.licenta.R
import com.example.licenta.dataClasses.training
import com.example.licenta.dateDeTest.Antrenament
import com.example.licenta.screens.BottomMenu.BottomNavigationBar
import java.util.Calendar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun trainingScreen(navController: NavController, scrollState: ScrollState, profileViewModel: ProfileViewModel) {
    var selectedDay by remember { mutableStateOf("Luni") }

    LaunchedEffect(Unit) {
        profileViewModel.setamAntrenamenteleSalvateDeUser()
    }

    val trainings by when (selectedDay) {
        "Luni" -> profileViewModel.antrenamentulDeLuni
        "Mar" -> profileViewModel.antrenamentulDeMarti
        "Mie" -> profileViewModel.antrenamentulDeMiercuri
        "Joi" -> profileViewModel.antrenamentulDeJoi
        "Vin" -> profileViewModel.antrenamentulDeVineri
        "Sam" -> profileViewModel.antrenamentulDeSambata
        "Dum" -> profileViewModel.antrenamentulDeDuminica
        else -> profileViewModel.antrenamentulDeLuni
    }.observeAsState(emptyList())

    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navController) }
    ) {
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.img1),
                        contentDescription = "Icon Left",
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )

                    Text(
                        text = "TRAINING",
                        color = colorResource(id = R.color.training_titile),
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Medium,
                            fontStyle = FontStyle.Normal
                        ),
                        modifier = Modifier
                            .weight(1f)
                            .wrapContentSize(Alignment.Center)
                    )

                    Image(
                        painter = painterResource(id = R.drawable.img1),
                        contentDescription = "Icon Right",
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
                Divider(
                    color = Color.Red,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .padding(horizontal = 3.dp),
                    thickness = 0.3.dp
                )

                calendarTraining { day ->
                    selectedDay = day

                    Log.d("SelectedDay", "Selected day: $selectedDay")
                }

                Image(
                    painter = painterResource(id = R.drawable.first_training_image),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxHeight(fraction = 0.3f)
                        .fillMaxWidth()
                )

                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 16.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
                ) {
                    items(trainings) { antrenament ->
                        trainingCard(antrenament, profileViewModel = profileViewModel, navController = navController)
                    }
                    item {
                        Spacer(modifier = Modifier.height(22.dp))
                    }
                }
            }
        }
    }
}

fun getCurrentDay(): String {
    val calendar = Calendar.getInstance()
    return when (calendar.get(Calendar.DAY_OF_WEEK)) {
        Calendar.MONDAY -> "Luni"
        Calendar.TUESDAY -> "Mar"
        Calendar.WEDNESDAY -> "Mie"
        Calendar.THURSDAY -> "Joi"
        Calendar.FRIDAY -> "Vin"
        Calendar.SATURDAY -> "Sam"
        Calendar.SUNDAY -> "Dum"
        else -> "Luni"
    }
}

@Composable
fun calendarTraining(onDaySelected: (String) -> Unit) {
    val currentDay = getCurrentDay()
    Row(
        modifier = Modifier
            .wrapContentSize()
            .padding(3.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        val days = listOf("Luni", "Mar", "Mie", "Joi", "Vin", "Sam", "Dum")

        days.forEach { day ->
            RoundNumberBadge(number = days.indexOf(day) + 1, day = day, isCurrentDay = day == currentDay) {
                onDaySelected(day) // Asigură-te că ziua este transmisă corect
            }
        }
    }
}

@Composable
fun RoundNumberBadge(number: Int, day: String, isCurrentDay: Boolean, onClick: () -> Unit) {
    Column(modifier = Modifier.padding(bottom = 8.dp, start = 5.dp)) {
        Text(text = day, modifier = Modifier.padding(start = 5.dp, top = 8.dp, bottom = 5.dp))

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .background(if (isCurrentDay) Color.Red else Color.LightGray, CircleShape)
                .clickable {
                    onClick() // Asigură-te că onClick este apelat
                }
        ) {
            Text(
                text = number.toString(),
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = if (isCurrentDay) Color.White else Color.Black
            )
        }
    }
}

@Composable
fun trainingCard(antrenament: training, profileViewModel: ProfileViewModel, navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = antrenament.img),
            contentDescription = null,
            modifier = Modifier
                .size(90.dp)
                .padding(end = 12.dp)
        )
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(end = 16.dp)
        ) {
            Text(
                text = antrenament.titlu,
                modifier = Modifier.wrapContentSize(),
                style = TextStyle(
                    fontSize = 17.sp,
                    fontStyle = FontStyle.Italic
                )
            )
            Row(
                modifier = Modifier
                    .wrapContentSize()
                    .padding(top = 4.dp)
            ) {
                Text(
                    text = "${antrenament.serii} ",
                    modifier = Modifier.wrapContentSize(),
                    style = TextStyle(fontSize = 14.sp)
                )
            }
        }
        Button(
            onClick = {
                profileViewModel.setExercitiuCurentStart(antrenament)
                navController.navigate("Tutorial")
            },
            modifier = Modifier
                .size(width = 70.dp, height = 30.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(id = R.color.start),
                contentColor = Color.White
            )
        ) {
            Text(
                text = "Start",
                style = TextStyle(fontSize = 12.sp, fontStyle = FontStyle.Italic)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun previewTrainingScreen() {
    trainingScreen(rememberNavController(), rememberScrollState(), ProfileViewModel())
}
