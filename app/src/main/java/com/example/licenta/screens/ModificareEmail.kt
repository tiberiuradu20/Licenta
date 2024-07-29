package com.example.licenta.screens

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.licenta.ProfileViewModel

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun modificareEmail(navController: NavController, scrollState: ScrollState, profileViewModel: ProfileViewModel) {
    val keyboardController = LocalSoftwareKeyboardController.current
    var email by remember { mutableStateOf(profileViewModel.getEmail().toString()) }
    var newEmail by remember { mutableStateOf(email) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Modificare/Stergere Email",
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
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(16.dp)
                .clickable { keyboardController?.hide() }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable { keyboardController?.hide() },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    value = newEmail,
                    onValueChange = { newEmail = it },
                    label = { Text("Email") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        email = newEmail
                        profileViewModel.setEmail(newEmail)
                    },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text("Modifica")
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = {
                        profileViewModel.setEmail("")
                    },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text("Stergere Email", color = Color.White)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun previewModificareEmail() {
    modificareEmail(navController = rememberNavController(), scrollState = rememberScrollState(), profileViewModel = ProfileViewModel())
}
