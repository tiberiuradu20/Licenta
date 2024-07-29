package com.example.licenta.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.runtime.Composable
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
import com.example.licenta.dateDeTest.Exercitii
import com.example.licenta.exerciti


@Composable
fun trainingCards(antremanet: exerciti,navController: NavController,scrollState: ScrollState) {
    Row(
        modifier = Modifier
            .fillMaxWidth() // Modifică de la fillMaxSize la fillMaxWidth pentru a folosi întreaga lățime disponibilă
            .padding(horizontal = 16.dp, vertical = 8.dp), // Ajustează padding-ul pentru aliniere
        verticalAlignment = Alignment.CenterVertically // Asigură alinierea verticală a elementelor în Row
    ) {
        Image(
            painter = painterResource(id = antremanet.image),
            contentDescription = null,
            modifier = Modifier
                .size(90.dp)
                .padding(end = 12.dp) // Ajustează padding-ul pentru aliniere
        )
        Column(
            modifier = Modifier
                .weight(1f) // Folosește weight pentru a distribui spațiul rămas
                .padding(end = 16.dp) // Ajustează padding-ul pentru aliniere
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
                    .padding(top = 4.dp)) {
                androidx.compose.material3.Text(
                    text = "${antremanet.nrDeExercitii}",
                    modifier = Modifier.wrapContentSize(),
                    style = TextStyle(fontSize = 14.sp)
                )
            }
        }
        androidx.compose.material3.Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
            contentDescription = "Back",
            modifier = Modifier.clickable {
                if(antremanet.titlu=="Picioare"){
                    navController.navigate("FitnessAcasaPicioare")
                }else if(antremanet.titlu=="Spate"){
                    navController.navigate("FitnessAcasaSpate")
                }else if(antremanet.titlu=="Piept"){
                    navController.navigate("FitnessAcasaPiept")
                }
            }
        )
    }
}

@Composable
fun fitnessAcasa(navController: NavController,scrollState: ScrollState,profileViewModel: ProfileViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Fitness Acasa",
                        modifier = Modifier.padding(0.dp),
                        style = TextStyle(fontSize = 19.sp, fontWeight = FontWeight.SemiBold)
                    )
                },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        modifier = Modifier.clickable {
                           // profileViewModel.adaugamAntrenamentePerZi()
                            profileViewModel.iesireAntrenament()
                            navController.popBackStack() }
                    )
                },
                backgroundColor = Color.White,
                contentColor = Color.Black,
                modifier = Modifier.fillMaxWidth()
            )
        }
    ){
        Column(modifier= Modifier
            .fillMaxSize()
            .padding(it)
            .padding(8.dp),
            horizontalAlignment = Alignment.Start){
           Spacer(modifier= Modifier.height(12.dp))
           Text(text="7 ANTRENAMENTE",
               style= TextStyle(
                   fontSize=15.sp,
                   fontWeight = FontWeight.SemiBold
               ))
            Column(modifier=Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 16.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
                ) {
                    items(Exercitii) { antrenament ->
                        trainingCards(antrenament,navController,scrollState)
                    }
                    item {
                        Spacer(modifier = Modifier.height(22.dp))
                    }
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun previewFitnessAcasa(){
    fitnessAcasa(navController = rememberNavController(),
        scrollState = rememberScrollState() , profileViewModel = ProfileViewModel() )
}