package com.example.licenta.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
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
import com.example.licenta.R
import com.example.licenta.dataClasses.training
import com.example.licenta.dateDeTest.Antrenament
import com.example.licenta.screens.BottomMenu.BottomNavigationBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun trainingScreen(navController: NavController, scrollState: ScrollState) {
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
                    thickness = 0.3.dp // Adjust padding to ensure the line starts and ends with the icons
                )

                calendarTraining()

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
                        .padding(16.dp)
                        .scrollable(scrollState, orientation = Orientation.Vertical)
                ) {
                    items(Antrenament) { antrenament ->
                        trainingCard(antrenament)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun previewTrainingScreen() {
    trainingScreen(rememberNavController(), rememberScrollState())
}

@Composable
fun RoundNumberBadge(number: Int, day: String = "SUN") {
    Column(modifier = Modifier.padding(bottom = 8.dp, start = 8.dp)) {
        Text(text = day, modifier = Modifier.padding(start = 10.dp, top = 8.dp, bottom = 5.dp))

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp) // Setează dimensiunea cercului
                .background(Color.LightGray, CircleShape) // Culoare de fundal și forma cercului
        ) {
            Text(
                text = number.toString(),
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
    }
}

@Composable
fun calendarTraining() {
    Row(
        modifier = Modifier
            .wrapContentSize()
            .padding(8.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        RoundNumberBadge(number = 30, day = "SUN")
        RoundNumberBadge(number = 1, day = "MON")
        RoundNumberBadge(number = 2, day = "TUE")
        RoundNumberBadge(number = 3, day = "WED")
        RoundNumberBadge(number = 4, day = "THU")
        RoundNumberBadge(number = 5, day = "FRY")
        RoundNumberBadge(number = 6, day = "SAT")
    }
}

@Composable
fun trainingCard(antremanet: training) {
    Row(
        modifier = Modifier
            .fillMaxWidth() // Modifică de la fillMaxSize la fillMaxWidth pentru a folosi întreaga lățime disponibilă
            .padding(horizontal = 16.dp, vertical = 8.dp), // Ajustează padding-ul pentru aliniere
        verticalAlignment = Alignment.CenterVertically // Asigură alinierea verticală a elementelor în Row
    ) {
        Image(
            painter = painterResource(id = antremanet.img),
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
            Text(
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
                Text(
                    text = "${antremanet.serii} serii",
                    modifier = Modifier.wrapContentSize(),
                    style = TextStyle(fontSize = 14.sp)
                )
            }
        }
        Button(
            onClick = { /* Handle onClick */ },
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
