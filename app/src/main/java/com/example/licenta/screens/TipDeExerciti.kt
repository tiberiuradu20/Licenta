package com.example.licenta.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.licenta.ProfileViewModel
import com.example.licenta.R

@Composable
fun tipDeExerciti(navController: NavController, scrollState: ScrollState, viewModel: ProfileViewModel) {
    Scaffold(topBar = {
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
            contentColor = Color.Black)
    },modifier= Modifier.fillMaxSize().padding(4.dp)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Alege tipul de exercitiu pe care vrei sa-l faci",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(top = 40.dp)
            )
            // Define common padding and height for buttons
            val buttonModifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .height(60.dp)  // Set a common height for all buttons

            // Reusable button composable
            @Composable
            fun ExerciseButton(text: String, iconResId: Int,onClick:()->Unit) {
                Button(
                    onClick = onClick ,
                    modifier = buttonModifier,
                    colors = ButtonDefaults.buttonColors(Color.LightGray)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Image(
                            painter = painterResource(id = iconResId),
                            contentDescription = "Icon",
                            modifier = Modifier
                                .size(24.dp)
                                .padding(end = 8.dp)
                        )
                        Text(
                            text = text,
                            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 15.sp),
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )

                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                            contentDescription = "Back",
                            modifier = Modifier.clickable { }
                        )
                    }
                }
            }
            Spacer(modifier=Modifier.height(60.dp))
            ExerciseButton("Fitness Acasa", R.drawable.acasa, onClick = { navController.navigate("AntrenamentGestionatPeZile") })
            Spacer(modifier=Modifier.height(42.dp))
            ExerciseButton("Sala", R.drawable.sala,onClick = { navController.navigate("AntrenamentGestionatPeZile") })
            Spacer(modifier=Modifier.height(42.dp))
            ExerciseButton("Cardio", R.drawable.cardio,onClick = { navController.navigate("AntrenamentGestionatPeZile") })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun tipPreview() {
    tipDeExerciti(rememberNavController(), rememberScrollState(), ProfileViewModel())
}
