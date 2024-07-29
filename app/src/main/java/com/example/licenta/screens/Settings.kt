package com.example.licenta.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.licenta.R

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun settingsScreen(navController: NavController, scrollState: ScrollState) {
    Scaffold(
        bottomBar = { BottomMenu.BottomNavigationBar(navController = navController) }
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
                    .verticalScroll(scrollState),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_settings),
                        contentDescription = "Icon Left",
                        modifier = Modifier
                            .size(24.dp)
                            .align(Alignment.CenterVertically)
                    )

                    Text(
                        text = "SETTINGS",
                        color = colorResource(id = R.color.training_titile),
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Medium
                        ),
                        modifier = Modifier
                            .weight(1f)
                            .wrapContentSize(Alignment.Center)
                    )

                    Image(
                        painter = painterResource(id = R.drawable.ic_settings),
                        contentDescription = "Icon Right",
                        modifier = Modifier
                            .size(24.dp)
                            .align(Alignment.CenterVertically)
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
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 35.dp),
                    verticalArrangement = Arrangement.spacedBy(25.dp)
                ) {
                    SettingItem(
                        navController=navController,
                        iconId = R.drawable.profile,
                        text = "My Profile",
                        onClick = { /*TODO*/ }
                    )
                    SettingItem(
                        navController=navController,
                        iconId = R.drawable.cantar,
                        text = "SI to USC",
                        onClick = { /*TODO*/ }
                    )
                    SettingItem(
                        navController=navController,
                        iconId = R.drawable.reminders,
                        text = "Reminders",
                        onClick = { /*TODO*/ }
                    )
                    SettingItem(
                        navController=navController,
                        iconId = R.drawable.email,
                        text = "Email",
                        onClick = { /*TODO*/ }
                    )
                    // New Section
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(16.dp))
                            .background(Color.LightGray)
                            .padding(10.dp)
                            .fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            verticalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            SettingItemNoClick(iconId = R.drawable.beculet, text = "Train Smart")
                            SettingItemNoClick(iconId = R.drawable.stire, text = "See What's New")
                            SettingItemNoClick(iconId = R.drawable.ajutor, text = "Help")
                            SettingItemNoClick(iconId = R.drawable.distribuie, text = "Share with Friends")
                        }
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    // FITNESS Section
                    Row(

                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.forta),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(1.dp))
                        Text(
                            text = "FITNESS",
                            style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun SettingItem(iconId: Int, text: String, onClick: () -> Unit,
                navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.LightGray)
            .clickable(onClick = {
                when(text){
                   "My Profile" -> navController.navigate("ProfileScreen")
                    "SI to USC" -> navController.navigate("SiToUsc")
                    "Email"->navController.navigate("ModificareEmail")
                    "Reminders"->navController.navigate("Reminders")
                    else -> navController.navigate("ProfileScreen")
                }
            }),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 9.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = iconId),
                contentDescription = null,
                modifier = Modifier.size(25.dp)
            )
            Text(
                text = text,
                style = TextStyle(fontSize = 15.sp, fontWeight = FontWeight.SemiBold),
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 20.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.sageata),
                contentDescription = null,
                modifier = Modifier.size(25.dp)
            )
        }
    }
}

@Composable
fun SettingItemNoClick(iconId: Int, text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = iconId),
            contentDescription = null,
            modifier = Modifier.size(25.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = text,
            style = TextStyle(fontSize = 15.sp, fontWeight = FontWeight.SemiBold)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun previewSettings() {
    settingsScreen(navController = rememberNavController(), scrollState = rememberScrollState())
}
