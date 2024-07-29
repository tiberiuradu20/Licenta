package com.example.licenta.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Button
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.example.licenta.dataClasses.training
import com.example.licenta.dateDeTest.Antrenament

@Composable
fun exercitiCard(
    antremanet: training,
    isSelected: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .background(if (isSelected) Color.LightGray else Color.Transparent),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = antremanet.img),
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
            androidx.compose.material3.Text(
                text = antremanet.titlu,
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
                androidx.compose.material3.Text(
                    text = "${antremanet.serii}",
                    modifier = Modifier.wrapContentSize(),
                    style = TextStyle(fontSize = 14.sp)
                )
            }
        }
        Checkbox(
            checked = isSelected,
            onCheckedChange = onCheckedChange
        )
    }
}

@Composable
fun fitnessAcasaPicioare(
    navController: NavController,
    scrollState: ScrollState,
    profileViewModel: ProfileViewModel
) {
    val selectedTrainings by profileViewModel.antrenamentulCurent.observeAsState(listOf())

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Picioare",
                        modifier = Modifier.padding(0.dp),
                        style = TextStyle(fontSize = 19.sp, fontWeight = FontWeight.SemiBold)
                    )
                },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        modifier = Modifier.clickable {
                            navController.popBackStack()

                        }
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
                .padding(8.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "5 EXERCITII",
                style = TextStyle(
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 16.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
                ) {
                    items(Antrenament) { antrenament ->
                        val isSelected = selectedTrainings.contains(antrenament)
                        exercitiCard(
                            antremanet = antrenament,
                            isSelected = isSelected,
                            onCheckedChange = { checked ->
                                profileViewModel.selectTraining(antrenament)

                            }
                        )
                    }
                    item {
                        Spacer(modifier = Modifier.height(22.dp))
                    }
                }
                Spacer(modifier = Modifier.height(12.dp))

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun previewFitnessAcasaPicioare() {
    fitnessAcasaPicioare(
        navController = rememberNavController(),
        scrollState = rememberScrollState(),
        profileViewModel = ProfileViewModel()
    )
}
