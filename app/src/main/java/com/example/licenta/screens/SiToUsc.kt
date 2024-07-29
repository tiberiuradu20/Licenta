package com.example.licenta.screens

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.licenta.ProfileViewModel

@Composable
fun siToUsc(navController: NavController, scrollState: ScrollState, profileViewModel: ProfileViewModel) {
    val conversionOptions = listOf("Kg to Pounds", "Meters to Feet","Pound to Kg","Feet to Meters")
    var selectedConversion by remember { mutableStateOf(conversionOptions[0]) }
    var inputValue by remember { mutableStateOf("") }
    var convertedValue by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }

    fun convertValue(value: String, conversion: String): String {
        return try {
            val numericValue = value.toFloat()
            when (conversion) {
                "Kg to Pounds" -> (numericValue * 2.20462).toString()
                "Meters to Feet" -> (numericValue * 3.28084).toString()
                "Feet to Meters"->(numericValue/3.28084).toString()
                "Pounds to Kg"->(numericValue/2.20462).toString()
                else -> ""
            }
        } catch (e: NumberFormatException) {
            ""
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "SI To USC",
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
                .padding(16.dp)
        ) {
            TextField(
                value = inputValue,
                onValueChange = {
                    inputValue = it
                    convertedValue = convertValue(it, selectedConversion)
                },
                label = { Text("Enter value") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number), // Set numeric keyboard
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Box(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Conversion Type: ",
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .align(Alignment.CenterStart)
                )
                Column {
                    Button(onClick = { expanded = true }) {
                        Text(text = selectedConversion)
                    }
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        conversionOptions.forEach { option ->
                            DropdownMenuItem(onClick = {
                                selectedConversion = option
                                expanded = false
                                convertedValue = convertValue(inputValue, option)
                            }) {
                                Text(text = option)
                            }
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Converted Value: $convertedValue",
                style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun previewSiToUsc() {
    siToUsc(navController = rememberNavController(), scrollState = rememberScrollState(), profileViewModel = ProfileViewModel())
}
