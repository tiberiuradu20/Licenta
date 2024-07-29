package com.example.licenta.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.licenta.ProfileViewModel
import com.example.licenta.R

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun profileScreen(navController: NavController, scrollState: ScrollState, profileViewModel: ProfileViewModel) {
    val name by profileViewModel.name.observeAsState("Tiberiu") // Observăm LiveData din ViewModel
    val birthday by profileViewModel.birthday.observeAsState("10 mai 2001")
    val height by profileViewModel.height.observeAsState("180 cm")
    val initialWeight by profileViewModel.initialWeight.observeAsState("100 kg")
    val actualWeight by profileViewModel.actualWeight.observeAsState("97 kg")
    val targetWeight by profileViewModel.targetWeight.observeAsState("80 kg")
    val tipAntrenament by remember { mutableStateOf("Forță, Cardio") }
  /*  val navBackStackEntry by navController.currentBackStackEntryAsState()
    val profileViewModel = navBackStackEntry?.let {
        androidx.lifecycle.viewmodel.compose.viewModel<ProfileViewModel>(it)
    } ?: viewModel()*/
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Profilul meu") },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        modifier = Modifier.clickable { navController.popBackStack() }
                    )
                },
                backgroundColor = Color.White,
                contentColor = Color.Black
            )
        }
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
                    .verticalScroll(scrollState),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "Profile Image",
                    modifier = Modifier
                        .size(70.dp)
                        .background(Color.Gray, shape = CircleShape)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(text=name, fontWeight = FontWeight.Bold, fontSize = 18.sp)  // Afișăm numele observat
                Spacer(modifier = Modifier.height(16.dp))
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 16.dp)
                        .background(Color.LightGray)
                        .clip(shape = RoundedCornerShape(22.dp)),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ProfileDetailItem(label = "Nume", value = name, onClick = { navController.navigate("Nume") })
                    ProfileDetailItem(label = "Data nașterii", value = birthday, onClick = { navController.navigate("Birthday") })
                    ProfileDetailItem(label = "Înălțimea", value = height, onClick = { navController.navigate("Inaltime") })
                    ProfileDetailItem(label = "Greutatea inițială", value = initialWeight, onClick = { navController.navigate("InitialWeight") })
                    ProfileDetailItem(label = "Greutatea actuală", value = actualWeight, onClick = { navController.navigate("ActualWeight") })
                    ProfileDetailItem(label = "Greutatea țintă", value = targetWeight, onClick = { navController.navigate("TargetWeight") })
                    ProfileDetailItem(label = "Tip antrenament", value = tipAntrenament, onClick = { navController.navigate("TipDeExerciti") })
                }
            }
        }
    }
}

@Composable
fun ProfileDetailItem(label: String, value: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
            .clickable(onClick = onClick),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            style = TextStyle(
                fontWeight = FontWeight.Medium,
                fontSize = 15.sp
            ),
            modifier = Modifier.padding(start = 8.dp)
        )
        Text(
            text = value,
            style = TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 15.sp
            ),
            modifier = Modifier.padding(end = 16.dp)
        )
    }
    Divider(
        color = Color.Red,
        modifier = Modifier
            .fillMaxWidth()
            .height(0.3.dp),
        thickness = 0.1.dp
    )
}

@Preview(showBackground = true)
@Composable
fun previewProfileScreen() {
    profileScreen(navController = rememberNavController(), scrollState = rememberScrollState(),
        viewModel())
}
